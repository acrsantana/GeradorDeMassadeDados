package br.com.acrtech.geradordearquivos.model;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Teste implements TipoDeArquivo {

    Faker faker = new Faker();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    String codProtocolo = faker.numerify("20######/##");
    String codRequisicao = faker.numerify("1######");
    String ordem = faker.numerify("###########");
    String empresa = faker.company().name();


    @Override public String converte() {
        return    codProtocolo +
            "|" + codRequisicao +
            "|" + ordem +
            "|" + empresa;
    }

    @Override public String nomeDoArquivoASerGerado() {
        return "TESTE_" + formatter.format(LocalDateTime.now()) + ".TXT";
    }

    @Override public String dataMapCabecalho() {
        return "TESTE";
    }
}
