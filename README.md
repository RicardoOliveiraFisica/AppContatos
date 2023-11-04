# AppContatos - Aplicativo de Gerenciamento de Pessoas e seus contatos

Este aplicativo é o resultado final (da parte de Java) de um programa de treinamento de Jovens Profissionais pela Minsait em Java Spring e Angular, ministrados pelos professores Eduador, Gleyser e Rafael.

## Tecnologias Utilizadas

- **Java  17.0.6**
- **Maven 3.9.0**
- **MySQL 8.1.0**
- **Git 2.40.0**
- **Spring Boot 3.0.12** com as seguintes dependências: 
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Fasterxml
  - Validation
  - Swagger

## Conceitos Aplicados

Esse sistema fornece APIs RESTfull através de endpoints criados e gerenciados pelo Java Web com Spring Framework usa conceitos de Programação Orientada a Objetos (POO).
O sistema trata-se de uma aplicação back-end com o objetivo de gerenciar cadastros de pessoas e seu contatos.

## Setup da aplicação (local)

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
- Java  17
- Maven 3.9.0
- MySQL 8.1.0

## Preparando o ambiente

É necessário a criação da base de dados com o nome "treinamento" no banco MySQL, ou a troca do nome "treinamento" no arquivo application.properties.

## Instalação da aplicação

Primeiramente, faça o clone do repositório:

https://github.com/RicardoOliveiraFisica/AppContatos.git

Abra o projeto na sua IDE com o modo Open Projects from File System usando o Maven

Acesse e execute a class AppContatosApplication

Pronto. A aplicação está disponível em http://localhost:8080

Sua documentação e endpoints estão disponíveis pelo swagger em http://localhost:8080/swagger-ui/index.html

