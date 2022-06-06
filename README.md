# GeradorDeMassadeDados

Projeto que tem como objetivo gerar uma massa de dados para realização de testes de uma demanda Spring Batch. O projeto é bastante flexivel, sendo possivel informar o tipo de arquivo a ser migrado e a quantidade de registros.
Para definir novos tipos de arquivos, basta implementar a interface TipoDeArquivo que possui 3 métodos: <BR>
- public String converte(); -> Retorna a string a ser gravada no arquivo.<BR>
  Ex:<BR>
  @Override public String converte() {
        return    codProtocolo +
            "|" + codRequisicao +
            "|" + ordem +
            "|" + empresa;
    }
- public String nomeDoArquivoASerGerado();<BR>
- public String dataMapCabecalho();<BR>
