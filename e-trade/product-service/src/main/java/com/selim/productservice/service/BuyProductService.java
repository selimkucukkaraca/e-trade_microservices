package com.selim.productservice.service;

import com.selim.entity.product.ConfirmedCart;
import com.selim.entity.product.Product;
import com.selim.entity.product.PromoCode;
import com.selim.entity.user.Address;
import com.selim.entity.user.User;
import com.selim.productservice.client.UserServiceClient;
import com.selim.shared.product.request.ConfirmCartRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BuyProductService {

    private final BankAccountService bankAccountService;
    private final ConfirmedCardService confirmedCardService;
    private final CartService cartService;
    private final UserServiceClient userServiceClient;
    private final PromoCodeService promoCodeService;

    @Transactional
    public void buy(ConfirmCartRequest confirmCartRequest) {
        var cart = cartService.getCart(confirmCartRequest.getCartId());
        var bankAccount = bankAccountService.getByCardNumber(confirmCartRequest.getCardNumber());
        User fromDbUser = userServiceClient.getByMail(confirmCartRequest.getUserMail()).getBody();
        PromoCode code = promoCodeService.getByCodeText(confirmCartRequest.getCodeText().get());
        double productTotalPrice;

        productTotalPrice = cart.getProduct()
                .stream().mapToDouble(Product::getProductPrice).sum() - code.getAmount();


        cart.getProduct()
                .forEach((product) -> {
                    if (bankAccountService.validateCreditCard(confirmCartRequest)) {
                        if (bankAccount.getBalance() >= product.getProductPrice()) {
                            bankAccount.setBalance(bankAccount.getBalance() - productTotalPrice);
                            cartService.deleteByCartId(confirmCartRequest.getCartId());
                            Address fromDbAddress = userServiceClient.save(confirmCartRequest.getAddress()).getBody();
                            assert fromDbUser != null;
                            fromDbUser.getAddress().add(fromDbAddress);
                            ConfirmedCart confirmedCart = new ConfirmedCart(cart, fromDbUser);
                            confirmedCardService.save(confirmedCart);
                            bankAccountService.save(bankAccount);
                        }
                    }
                });
    }
}