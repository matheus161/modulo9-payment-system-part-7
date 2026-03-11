package com.eliasnogueira.paymentservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class ArgumentSourceTest {

    // Utilizado para alterar os dados entre os testes
    @ParameterizedTest
    @ArgumentsSource(PessoaArgumentSourceData.class)
    void podeVotarTest(Pessoa pessoa, String resultado) {
        Assertions.assertThat(pessoa.getIdade()).isGreaterThanOrEqualTo(18).isLessThanOrEqualTo(70);
        Assertions.assertThat(resultado).isEqualTo("Pode votar");
    }
}
