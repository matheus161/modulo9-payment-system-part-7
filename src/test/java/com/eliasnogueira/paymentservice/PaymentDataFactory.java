package com.eliasnogueira.paymentservice;

import com.eliasnogueira.paymentservice.dto.PaymentRequest;
import com.eliasnogueira.paymentservice.model.enums.PaymentSource;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
public class PaymentDataFactory {

    private static Faker faker = new Faker();

    private PaymentDataFactory() {}

    public static PaymentRequest validPaymentRequest() {
        var paymentRequest = basePaymentRequest();

        log.info("Creating valid payment request: {}", paymentRequest);

        return paymentRequest;
    }

    public static PaymentRequest invalidPaymentRequest() {
        var paymentRequest = basePaymentRequest();

        paymentRequest.setAmount(new BigDecimal("3000.00"));

        return paymentRequest;
    }

    private static PaymentRequest basePaymentRequest() {
        return PaymentRequest.builder()
                .payerId(UUID.randomUUID())
                .paymentSource(faker.options().option(PaymentSource.class))
                .amount(BigDecimal.valueOf(faker.number().numberBetween(1, 2000)))
                .build();
    }
}
