Descrição do Projeto Final. 
Crie uma API REST usando o Java Spring.  
Requisitos do projeto: 
* Usar Java Spring
* Ter ao menos 5 entidades 
* Criar Controller, Repository, Model, Serice e DTO para todas as models  
* Criar uma documentação para a API

  
Informações do projeto----

A ideia foi criar uma API simulando o backend de um sistema para uma ONG de resgate e adoção de animais. O objetivo é permitir o cadastro e mantimento de informações de animais, voluntários e adotantes, assim como o cadastro de eventos 
(adoção, vacinação, castração) com data, endereço e etc

Entidades (Models)---
* Animal: id, nome, espécie, raça, idade, porte, sexo, vacinado, castrado, status 
(disponível, adotado) 
* Adotante: id, nome, email, telefone, cpf, endereço 
* Adoção: id, animal, adotante, dataSolicitacao, status (pendente, aprovada, recusada) 
* Funcionário: id, nome, cargo, email, dataEntrada 
* Evento: id, no
