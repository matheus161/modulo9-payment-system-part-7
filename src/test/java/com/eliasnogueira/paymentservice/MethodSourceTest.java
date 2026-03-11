package com.eliasnogueira.paymentservice;

import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class MethodSourceTest {

    @ParameterizedTest
    @MethodSource("fonteDeDados")
    void podeVotarTest(Pessoa pessoa, String resultado) {
        Assertions.assertThat(pessoa.getIdade()).isGreaterThanOrEqualTo(18).isLessThanOrEqualTo(70);
        Assertions.assertThat(resultado).isEqualTo("Pode votar");
    }

    static Stream<Arguments> fonteDeDados() {
        return Stream.of(
                Arguments.arguments(new Pessoa("João", 18), "Pode votar"),
                Arguments.arguments(new Pessoa("Maria", 70), "Pode votar")
        );
    }
}
