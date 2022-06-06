package br.com.acrtech.geradordearquivos.model;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pesquisa implements TipoDeArquivo {

    Faker faker = new Faker();

    String codRequisicao = faker.numerify("#######");
    String numPesquisa = faker.numerify("##");
    String idPesquisaProtocolo = faker.numerify("######");
    String tipoBusca = faker.beer().name();
    String tipoPesquisa = faker.artist().name();
    String status = faker.pokemon().name();
    String tipoResultado = faker.file().extension();
    String direcao = faker.bool().bool() ? "Originadas" : "Recebidas";
    String dados1 = faker.bool().bool() ? "Sim" : "Não";
    String dados2 = faker.bool().bool() ? "Sim" : "Não";

    DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Override public String converte() {

        return codRequisicao +
            "|" + numPesquisa +
            "|" + idPesquisaProtocolo +
            "|" + tipoBusca +
            "|" + tipoPesquisa +
            "|" + status +
            "|" + tipoResultado +
            "|" + direcao +
            "|" + dados1 +
            "|" + dados2;
    }

    @Override public String nomeDoArquivoASerGerado() {
        return "PESQUISA_" + dataFormatter.format(LocalDateTime.now()) + ".TXT";
    }

    @Override public String dataMapCabecalho() {
        return "PESQUISA";
    }
}
