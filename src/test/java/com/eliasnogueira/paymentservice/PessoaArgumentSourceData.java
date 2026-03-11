package com.eliasnogueira.paymentservice;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class PessoaArgumentSourceData implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.arguments(new Pessoa("João", 18), "Pode votar"),
                Arguments.arguments(new Pessoa("Maria", 70), "Pode votar")
        );
    }
}
