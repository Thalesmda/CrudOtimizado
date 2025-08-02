# Meu Projeto Spring Boot CRUD 🚀

Este é um projeto exemplo de uma API REST feita com Java, Spring Boot e Spring Data JPA.

## Tecnologias Utilizadas 🛠

- Java 24
- Spring Boot
- Spring Data JPA
- Maven
- IntelliJ IDEA

## Criar e configurar Banco de Dados Mysql

CREATE DATABASE nomedobanco;
USE nomedobanco;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL    
);

  # Configurar application.properties
No arquivo src/main/resources/application.properties, adicione:

  # Conexão com o MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/skydb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456

# JPA e Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## Como rodar o projeto ▶️

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repo.git

Abra no IntelliJ IDEA

Rode a classe CrudOtimizadoApplication.java

Acesse: http://localhost:8080/usuarios

Endpoints disponíveis 🌐
GET /usuarios → Lista todos os usuários

POST /usuarios → Cria um novo usuário

PUT /usuarios/{id} → Atualiza um usuário existente

DELETE /usuarios/{id} → Remove um usuário

![crudeixon](https://github.com/user-attachments/assets/317c3e69-a707-42e0-8304-0f3a3592d8ce)


