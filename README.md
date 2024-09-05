Projeto java spring + arquitetura limpa, resolvendo um desafio da empresa UBER para criar um projeto, sendo então escolhido o EMAIL-SERVICE.

PAra tanto, o presente Projete foi gerado inicialmente (pré-projeto) pelo site start.spring.io, adicionamos as dependencias SPRING BOOT DEVTOLLS(DEVELOPER TOOLS), Spring WEb(WEB)
e Lombok((DEVELOPER TOOLS), gerando assim um arquivo comprimido(Zip) que iniciado no VSCode ou Ibtellij, começamos codificar.

Em seguida, no arquivo POM.xml, adicinamos a dependencia "AWS SES" indicando a versão, após spring boot starter test:
<!-- https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk -->
<dependency>
    <groupId>com.amazonaws</groupId>
    <artifactId>aws-java-sdk</artifactId>
    <version>1.12.472</version>
</dependency>

Asssim, no CORE do nosso aplicativo, criamos as "regras de negócio" de como é implementado por fora(usando aws ses ou nao), no main do SRC.
sendo as regras o email em si contendo "subject", "to"(destinatario), body(corpo da mensagem). 

Obs: o fron não (pq nos nao cabe nesse caso)



