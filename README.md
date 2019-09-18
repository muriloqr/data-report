# Data Report

## Utilizado

Java 8

### Antes de executar

Verifique se existe as pastas data/in e data/out no diretorio da sua home

### Sobre

Quando o projeto for executado, ele lerá os arquivos que estão definidos no diretório home do usuario /data/in e processará gerando o arquivo "report", dentro da pasta do diretório do usuario /data/out/

Caso não houver arquivos na iniciação da aplicação na pasta no diretório home do usuario /data/in, a aplicação mostrará uma exception avisando que não há arquivos, e assim que for inserido algum arquivo ele gerará o report.

Qualquer inclusão ou deleção de arquivos durante a execução na pasta /data/in a aplicação irá gerar o relatório novamente.

Como não havia definido o tipo de arquivo de saida, será gerado um sem extensão, mas pode ser aberto como texto para visualização.
