package br.com.acrtech.geradordearquivos.model;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Arquivo1 implements TipoDeArquivo {

    Faker faker = new Faker();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    String codigo1 = faker.numerify("#######");
    String codigo2 = faker.numerify("########/##");
    String numero1 = faker.numerify("#######");
    String data1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(faker.date().birthday(0, 10));
    String cidade = faker.address().cityName();
    String empresa = faker.company().name();
    String extra = faker.beer().name();
    String tipo = faker.beer().style();

    @Override public String converte() {

        return codigo1 +
            "|" + codigo2 +
            "|" + numero1 +
            "|" + data1 +
            "|" + cidade +
            "|" + empresa +
            "|" + extra +
            "|" + tipo;
    }

    @Override public String nomeDoArquivoASerGerado() {

        return "ARQUIVO1_" +
            formatter.format(LocalDateTime.now()) + ".TXT";
    }

    @Override public String dataMapCabecalho() {
        return "ARQUIVO1";
    }
}
