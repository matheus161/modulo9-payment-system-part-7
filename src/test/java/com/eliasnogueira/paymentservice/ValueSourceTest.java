package com.eliasnogueira.paymentservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourceTest {

    @ParameterizedTest(name = "Pode votar com a idade {0}")
    @ValueSource(ints = {18, 20, 30, 40, 50, 60, 70})
    void valuerSourceTest(int idade) {
        Assertions.assertThat(podeVotar(idade)).isTrue();
    }

    public boolean podeVotar(int idade) {
        boolean resultado = false;

        if (idade >= 18 && idade <= 70) {
            return true;
        }

        return resultado;
    }
}
