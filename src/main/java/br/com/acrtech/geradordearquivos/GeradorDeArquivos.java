package br.com.acrtech.geradordearquivos;

import br.com.acrtech.geradordearquivos.service.GeraArquivoService;

public class GeradorDeArquivos {
    static GeraArquivoService service = new GeraArquivoService();
    public static void main(String[] args) {
        try {
            service.geraArquivo(args);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
