package com.eliasnogueira.paymentservice.unit;

import com.eliasnogueira.paymentservice.validator.PaymentLimitValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentValidatorTest {

    @Test
    @DisplayName("Payment should be successful when amount is below the daily limit")
    void shouldAcceptAmountBelowTheLimit() {
        BigDecimal amount = new BigDecimal("1999.99");
        assertThat(PaymentLimitValidator.isWithinLimit(amount)).isTrue();
    }

    @Test
    @DisplayName("Payment should be successful when amount equal the daily limit")
    void shouldAcceptAmountEqualToTheLimit() {
        BigDecimal amount = new BigDecimal("2000.00");
        assertThat(PaymentLimitValidator.isWithinLimit(amount)).isTrue();
    }

    @Test
    @DisplayName("Payment should not be successful when amount is higher than the daily limit")
    void shouldNotAcceptAmountHigherThanTheLimit() {
        BigDecimal amount = new BigDecimal("2000.01");
        assertThat(PaymentLimitValidator.isWithinLimit(amount)).isFalse();
    }

    @Test
    @DisplayName("Payment should be successful when amount is null")
    void shouldNotAcceptANullValue() {
        assertThat(PaymentLimitValidator.isWithinLimit(null)).isFalse();
    }

    @ParameterizedTest(name = "Payment should not be successful when value is ${0}")
    @MethodSource("edgeCasesForLimit")
    void shouldNotAcceptEdgeCases(BigDecimal amount) {
        assertThat(PaymentLimitValidator.isWithinLimit(amount)).isFalse();
    }

    static Stream<Arguments> edgeCasesForLimit() {
        return Stream.of(
                Arguments.arguments(new BigDecimal("00.00")),
                Arguments.arguments(new BigDecimal("2000.01")),
                Arguments.arguments(new BigDecimal("3500.00"))
        );
    }

    @ParameterizedTest(name = "Payment should be successful when value is ${0}")
    @MethodSource("happyPathsForLimit")
    void shouldAcceptAmountUnderTheLimit(BigDecimal amount) {
        assertThat(PaymentLimitValidator.isWithinLimit(amount)).isTrue();
    }

    static Stream<Arguments> happyPathsForLimit() {
        return Stream.of(
                Arguments.arguments(new BigDecimal("00.1")),
                Arguments.arguments(new BigDecimal("1999.99")),
                Arguments.arguments(new BigDecimal("2000.00"))
        );
    }
}
