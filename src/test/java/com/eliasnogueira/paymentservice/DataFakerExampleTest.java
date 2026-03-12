package com.eliasnogueira.paymentservice;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

public class DataFakerExampleTest {

    @Test
    void dataFakerExample() {
        Faker faker = new Faker();

        var fullName = faker.name().fullName();
        var address = faker.address().fullAddress();
        var cpf = faker.cpf().valid(true);
        var username = faker.credentials().username();
        var password = faker.credentials().password(12, 24);

        System.out.println(fullName);
        System.out.println(address);
        System.out.println(cpf);
        System.out.println(username);
        System.out.println(password);
    }
}
