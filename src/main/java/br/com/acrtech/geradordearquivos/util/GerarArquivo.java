package br.com.acrtech.geradordearquivos.util;

import br.com.acrtech.geradordearquivos.model.TipoDeArquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerarArquivo {

    String nomeDoArquivoASerGerado;
    String cabecalhoDoArquivoASerGerado;
    FileWriter arquivoASerGerado;
    PrintWriter gravaArquivoASerGerado;
    int totalDeRegistrosGravadosNoArquivo = 0;
    public GerarArquivo(TipoDeArquivo objeto) {
        nomeDoArquivoASerGerado = objeto.nomeDoArquivoASerGerado();
        cabecalhoDoArquivoASerGerado = objeto.dataMapCabecalho();

        try {
            arquivoASerGerado = new FileWriter(nomeDoArquivoASerGerado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gravaArquivoASerGerado = new PrintWriter(arquivoASerGerado);
    }

    public void resetaTotalDeRegistrosNoArquivo() {
        totalDeRegistrosGravadosNoArquivo = 0;
    }

    public void imprimeCabecalhoNoArquivo(){
        gravaArquivoASerGerado.println(cabecalhoDoArquivoASerGerado);
    }
    public void doTipo(TipoDeArquivo objetoASerGravado) throws IOException {
        gravaArquivoASerGerado.println(objetoASerGravado.converte());
        totalDeRegistrosGravadosNoArquivo++;
    }

    public void imprimeRodapeNoArquivo(){
        gravaArquivoASerGerado.println(totalDeRegistrosGravadosNoArquivo);
    }

    public void close() throws IOException {
        gravaArquivoASerGerado.close();
        arquivoASerGerado.close();
    }
}
