package com.eliasnogueira.paymentservice;

import lombok.Getter;

public class Pessoa {
    @Getter
    private String nome;
    @Getter
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
