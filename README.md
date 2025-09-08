# 📌 Desafio Spring Web

Este projeto foi desenvolvido como parte de um **desafio Backend do Itaú** (encontrado na internet), utilizando o framework **Spring Boot** com **Spring Web**.

O objetivo foi construir uma aplicação REST simples **sem integração com banco de dados**, seguindo os requisitos definidos no desafio.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3+**
    - Spring Web
    - DevTools
    - Validation
- **Maven** (gerenciador de dependências)
- **Insomnia/Postman** (para testes de API)

---

## ⚙️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Manoel-DJS/Desafio-Backend-Itau
   ```

2. Entre no diretório do projeto:
   ```bash
   cd DiretorioDoProjeto
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a aplicação em:
   ```
   http://localhost:8080
   ```

---

## 🔗 Endpoints Principais

| Método | Endpoint        | Descrição                         |
|--------|-----------------|-----------------------------------|
| GET    | `/estatistica`  | Lista todas as transacoes         |
| POST   | `/transacao`    | Cria uma nova transacao           |
| DELETE | `/transacao` | Remove todas as transacoes da fila |

> ⚠️ Como não há persistência em banco de dados, os dados são mantidos **em memória** apenas durante a execução da aplicação.

---

## 🧪 Testes

Os endpoints podem ser testados via:
- **Insomnia/Postman**
- **Testes unitários** A Implementar.

---
