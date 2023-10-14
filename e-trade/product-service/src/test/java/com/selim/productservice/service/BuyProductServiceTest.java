package com.selim.productservice.service;

import com.selim.productservice.TestUtil;
import com.selim.productservice.client.UserServiceClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class BuyProductServiceTest extends TestUtil {

    private BankAccountService bankAccountService;
    private ConfirmedCardService confirmedCardService;
    private CartService cartService;
    private UserServiceClient userServiceClient;
    private PromoCodeService promoCodeService;
    private BuyProductService buyProductService;

    @BeforeEach
    public void setUp() {
        bankAccountService = mock(BankAccountService.class);
        confirmedCardService = mock(ConfirmedCardService.class);
        cartService = mock(CartService.class);
        userServiceClient = mock(UserServiceClient.class);
        promoCodeService = mock(PromoCodeService.class);
        buyProductService = new BuyProductService(bankAccountService,
                confirmedCardService,cartService,userServiceClient,promoCodeService);

    }

    @Test
    void buy() {
        //TODO
    }
}
