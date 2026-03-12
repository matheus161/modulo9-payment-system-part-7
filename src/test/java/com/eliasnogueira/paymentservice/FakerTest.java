package com.eliasnogueira.paymentservice;

import org.junit.jupiter.api.Test;

public class FakerTest {

    @Test
    void dataFakerTest() {
        var validPaymentRequest = PaymentDataFactory.validPaymentRequest();
        var invalidPaymentRequest = PaymentDataFactory.invalidPaymentRequest();
    }
}
