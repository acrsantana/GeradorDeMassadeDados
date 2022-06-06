package br.com.acrtech.geradordearquivos.service;

import br.com.acrtech.geradordearquivos.model.TipoDeArquivo;
import br.com.acrtech.geradordearquivos.util.GerarArquivo;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeraArquivoService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public void geraArquivo(String[] args){
        if (args.length != 2){
            throw new RuntimeException("Quantidade inválida de parâmetros, favor informar tipo de arquivo e quantidade de registros");
        }

        try {
            String classeASerInstanciadaFQDN = "br.com.acrtech.geradordearquivos.model." + args[0];
            Integer quantidadeDeRegistrosASeremGerados = Integer.parseInt(args[1]);
            LocalDateTime horaInicio = LocalDateTime.now();
            Class<?> classe = Class.forName(classeASerInstanciadaFQDN);
            GerarArquivo grava = new GerarArquivo((TipoDeArquivo) classe.newInstance());
            imprimeCabecalho(classeASerInstanciadaFQDN, quantidadeDeRegistrosASeremGerados, horaInicio);
            gravaDadosNoArquivo(quantidadeDeRegistrosASeremGerados, classe, grava);
            imprimeRodape(quantidadeDeRegistrosASeremGerados, horaInicio);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | NumberFormatException e){
            throw new RuntimeException(e);
        }
    }

    private void imprimeCabecalho(String classeASerInstanciadaFQDN, Integer quantidadeDeRegistrosASeremGerados, LocalDateTime horaInicio) {
        System.out.println("Inicio: " + horaInicio.format(formatter));
        System.out.println(String.format("Iniciando a geração dos dados %s, isto pode demorar um tempo...", classeASerInstanciadaFQDN));
        System.out.println(String.format("Gerando o total de %s registros.", quantidadeDeRegistrosASeremGerados));
    }

    private void imprimeRodape(Integer quantidadeDeRegistrosASeremGerados, LocalDateTime horaInicio) {
        System.out.println("Arquivo gerado com sucesso");
        LocalDateTime horaFim = LocalDateTime.now();
        Duration duracao = Duration.between(horaInicio, horaFim);
        System.out.println("Fim: " + horaFim.format(formatter));
        System.out.println("Tempo total de execução: " + duracao.getSeconds() + " segundos.");
        System.out.println(String.format("%s registros gravados", quantidadeDeRegistrosASeremGerados));
    }

    private void gravaDadosNoArquivo(Integer quantidadeDeRegistrosASeremGerados, Class<?> classe, GerarArquivo grava)
        throws IOException, InstantiationException, IllegalAccessException {
        grava.imprimeCabecalhoNoArquivo();
        for (int i = 0; i < quantidadeDeRegistrosASeremGerados; i++){
            grava.doTipo((TipoDeArquivo) classe.newInstance());
        }
        grava.imprimeRodapeNoArquivo();
        grava.close();
    }

}
