package com.eliasnogueira.paymentservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

public class CsvSourceTest {

    private static final String MAX_PRICE = "30.00";

    @ParameterizedTest(name = "Produto {0} no valor de {1} deve ser menor que " + MAX_PRICE)
    @CsvSource({
            "Micro SD Card 16Gb, 6.09",
            "Mouse, 22.50",
            "iPad Air Case, 4.99"
    })
    void produtoMenorQuePrecoMaximo(String nomeProduto, BigDecimal valor) {
        Assertions.assertThat(nomeProduto).isNotEmpty();
        Assertions.assertThat(valor).isLessThanOrEqualTo(new BigDecimal(MAX_PRICE));
    }

    @ParameterizedTest(name = "Produto {0} no valor de {1} deve ser menor que " + MAX_PRICE)
    @CsvFileSource(resources = "/produtos.csv", numLinesToSkip = 1)
    void produtoMenorQuePrecoMaximo2(String nomeProduto, BigDecimal valor) {
        Assertions.assertThat(nomeProduto).isNotEmpty();
        Assertions.assertThat(valor).isLessThanOrEqualTo(new BigDecimal(MAX_PRICE));
    }
}
