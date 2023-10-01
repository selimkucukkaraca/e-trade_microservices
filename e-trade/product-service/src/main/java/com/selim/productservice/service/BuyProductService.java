package com.selim.productservice.service;

import com.selim.entity.product.ConfirmedCart;
import com.selim.entity.product.Product;
import com.selim.entity.product.PromoCode;
import com.selim.entity.user.Address;
import com.selim.shared.product.request.ConfirmCartRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyProductService {

    private final BankAccountService bankAccountService;
    private final ConfirmedCardService confirmedCardService;
    private final CartService cartService;
    private final UserService userService;
    private final AddressService addressService;
    private final PromoCodeService promoCodeService;

    public BuyProductService(BankAccountService bankAccountService,
                             ConfirmedCardService confirmedCardService,
                             CartService cartService, UserService userService,
                             AddressService addressService,
                             PromoCodeService promoCodeService) {
        this.bankAccountService = bankAccountService;
        this.confirmedCardService = confirmedCardService;
        this.cartService = cartService;
        this.userService = userService;
        this.addressService = addressService;
        this.promoCodeService = promoCodeService;
    }

    @Transactional
    public void buy(ConfirmCartRequest confirmCartRequest) {
        var cart = cartService.getCart(confirmCartRequest.getCartId());
        var bankAccount = bankAccountService.getByCardNumber(confirmCartRequest.getCardNumber());
        var user = userService.getUserByMail(confirmCartRequest.getUserMail());
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
                            Address address = addressService.save(confirmCartRequest.getAddress());
                            user.getAddress().add(address);
                            ConfirmedCart confirmedCart = new ConfirmedCart(cart, user);
                            confirmedCardService.save(confirmedCart);
                            bankAccountService.save(bankAccount);
                        }
                    }
                });
    }
}