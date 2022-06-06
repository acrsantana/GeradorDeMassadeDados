# GeradorDeMassadeDados

Projeto que tem como objetivo gerar uma massa de dados para realização de testes de uma demanda Spring Batch. O projeto é bastante flexivel, sendo possivel informar o tipo de arquivo a ser migrado e a quantidade de registros.
Para definir novos tipos de arquivos, basta implementar a interface TipoDeArquivo que possui 3 métodos: <BR>
- public String converte(); -- Retorna a string a ser gravada no arquivo.<BR>
  Ex:<BR>
  `@Override public String converte() {
        return    codProtocolo +
            "|" + codRequisicao +
            "|" + ordem +
            "|" + empresa;
    }`<BR>
  Os campos listados acima (codProtocolo, codRequisicao, ordem e empresa) são atributos da classe que implementa TipoDeArquivo. No exemplo em questão eles são atributos da classe Teste.<BR>

- public String nomeDoArquivoASerGerado(); -- Retorna a string com o nome do arquivo a ser gerado.<BR>
  Ex:<BR>
  `@Override public String nomeDoArquivoASerGerado() {
  return "TESTE_" + formatter.format(LocalDateTime.now()) + ".TXT";
  }`
- public String dataMapCabecalho(); -- Cabeçalho do arquivo a ser gerado.<BR>
  EX:<BR>
  `@Override public String dataMapCabecalho() {
  return "TESTE";
  }`
