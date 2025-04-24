# 🏅 CRUD Sports API

Este projeto é uma API REST em Java com Spring Boot que permite realizar operações CRUD (Create, Read, Update, Delete) para gerenciar diferentes esportes.

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Maven
- Bean Validation (javax)

---

## 📦 Como Rodar o Projeto

### Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- Java 17 instalado
- IDE (como IntelliJ, VSCode, Eclipse...)

### Rodando com Docker Compose

1. Clone o projeto:
```bash
git clone https://github.com/seu-usuario/crud-sports.git
cd crud-sports

docker-compose up -d
http://localhost:8080
```

### 📂 Estrutura do Projeto
 - SportEntity: representa a entidade Esporte.

 - SportRepository: interface JPA que faz a conexão com o banco de dados.

 - SportService: lógica de negócio para cadastro e manipulação dos esportes.

 - SportController: responsável por expor os endpoints da API.

### ✅ Funcionalidades
 - Criar um novo esporte

 - Listar todos os esportes

 - Listar um esporte específico por ID

 - Atualizar dados de um esporte existente

 - Deletar um esporte

### 📮 Endpoints
🔹 Criar esporte
POST /api/esportes
Content-Type: application/json

Exemplo de JSON:
{
  "nome": "futebol",
  "descricao": "esporte futebol",
  "numeroJogadores": 11,
  "tipo": "coletivo",
  "olimpico": true,
  "paisOrigem": "Inglaterra",
  "anoCriacao": 1863
}

🔹 Listar todos os esportes
GET /api/esportes

🔹 Listar um esporte por ID
GET /api/esportes/{id}

🔹 Atualizar um esporte
PUT /api/esportes/{id}

Exemplo de JSON:
{
  "nome": "Futebol Atualizado",
  "descricao": "Esporte coletivo com bola",
  "numeroJogadores": 11,
  "tipo": "coletivo",
  "olimpico": true,
  "paisOrigem": "Brasil",
  "anoCriacao": 1865
}

🔹 Deletar um esporte
DELETE /api/esportes/{id}

### 🔒 Validações implementadas
As validações estão aplicadas diretamente na SportEntity usando anotações do Bean Validation:

@NotBlank para campos obrigatórios (strings)

@Min e @Max para limites numéricos (ex: ano de criação)

@Size para limitar comprimento de textos

### 🐘 Banco de Dados
Utiliza PostgreSQL

Configurado via docker-compose.yml

Dados de acesso padrão definidos no arquivo

Exemplo de acesso no application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/sportsdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update


