# ⚖️ Sistema de Gestão de Escritório Advocatício

Um sistema para gerenciamento de escritórios de advocacia desenvolvido em **Java** com **Spring Boot**. A aplicação oferece suporte para gestão das principais entidades do domínio jurídico: **Advogados**, **Clientes**, **Processos** e **Documentos**.

## 🛠️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot** (Spring Data JPA, Spring Web)
* **MySQL** (Banco de dados relacional)
* **Maven** (Gerenciamento de dependências e build)
* **Lombok** (Redução de código boilerplate)

## 📂 Estrutura do Projeto

```
escritorio/
├── src/
│   ├── main/
│   │   ├── java/com/exemplo/escritorio/
│   │   │   ├── controller/      # Endpoints REST (Advogado, Cliente, Processo, Documento)
│   │   │   ├── model/           # Entidades de domínio (JPA)
│   │   │   ├── repository/      # Camada de acesso a dados (Spring Data JPA)
│   │   │   ├── service/         # Regras de negócio da aplicação
│   │   │   └── EscritorioApplication.java
│   │   └── resources/
│   │       └── application.properties # Configurações da aplicação e BD
└── pom.xml
```

## 🚀 Como Executar o Projeto

### Pré-requisitos

* **Java 17** ou superior instalado.
* **Maven** instalado (ou utilize o Maven Wrapper `./mvnw` incluso no projeto).

### Passos para Execução

1. Clone este repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd escritorio
   ```

2. Execute o projeto via Maven Wrapper:

   * **Linux/macOS:**
     ```bash
     ./mvnw spring-boot:run
     ```
   * **Windows:**
     ```cmd
     mvnw.cmd spring-boot:run
     ```

3. A API estará acessível em `http://localhost:8080`.

## 📍 Endpoints da API

### 👨‍⚖️ Advogados (`/api/advogados`)
* `GET /api/advogados` - Lista todos os advogados cadastrados.
* `GET /api/advogados/{id}` - Retorna os dados de um advogado por ID.
* `POST /api/advogados` - Cadastra um novo advogado.
* `PUT /api/advogados/{id}` - Atualiza os dados de um advogado existente.
* `DELETE /api/advogados/{id}` - Remove um advogado do sistema.

### 👤 Clientes (`/api/clientes`)
* `GET /api/clientes` - Lista todos os clientes cadastrados.
* `GET /api/clientes/{id}` - Retorna os dados de um cliente por ID.
* `POST /api/clientes` - Cadastra um novo cliente.
* `PUT /api/clientes/{id}` - Atualiza os dados de um cliente existente.
* `DELETE /api/clientes/{id}` - Remove um cliente do sistema.

### 📑 Processos (`/api/processos`)
* `GET /api/processos` - Lista todos os processos.
* `GET /api/processos/{id}` - Retorna um processo específico por ID.
* `POST /api/processos` - Registra um novo processo.
* `PUT /api/processos/{id}` - Atualiza as informações de um processo.
* `DELETE /api/processos/{id}` - Remove um processo.

### 📄 Documentos (`/api/documentos`)
* `GET /api/documentos` - Lista todos os documentos registrados.
* `GET /api/documentos/{id}` - Retorna um documento específico por ID.
* `POST /api/documentos` - Anexa/cadastra um novo documento.
* `PUT /api/documentos/{id}` - Atualiza as informações de um documento.
* `DELETE /api/documentos/{id}` - Remove um documento.



                                                                                 ### **Autor: Heitor Queiroga Tavares**
