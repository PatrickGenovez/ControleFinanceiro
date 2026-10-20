# 🚀 Fase 02 — Migração para Spring Boot & Spring Data JPA

**Data de Início:** 19/10/2026  
**Status:** 🟡 Em Andamento  
**Branch Prevista:** `feat/spring-boot-jpa`

---

## 🎯 Por que estamos migrando para Spring Boot + Spring Data JPA?
Na Fase 01, aprendemos o JDBC puro: escrevemos SQL na mão, abrimos conexão com `DriverManager` e mapeamos `ResultSet`.
Agora, o Spring Boot entra para:
1. **Eliminar Boilerplate:** Não precisaremos mais de `ConnectionFactory`, nem de escrever `PreparedStatement` ou mapear colunas manualmente.
2. **Gerenciador de Dependências (Maven):** O arquivo `pom.xml` gerencia bibliotecas sem precisarmos de arquivos `.jar` soltos na pasta `lib/`.
3. **ORM (Object Relational Mapping) com JPA/Hibernate:** Nossas classes Java viram tabelas no banco através de anotações (`@Entity`, `@Table`, `@Id`).
4. **Spring Data Repositories:** Criaremos interfaces que estendem `JpaRepository`, ganhando métodos como `save()`, `findById()`, `findAll()`, `delete()` prontos sem uma linha sequer de SQL manual.
5. **Injeção de Dependências (IoC):** O Spring gerencia o ciclo de vida dos nossos objetos com anotações como `@Service` e `@Autowired` / injeção via construtor.

---

## 📋 Passo a Passo de Execução

- [x] **Passo 1: Branch no Git**
  - Branch `feat/spring-boot-jpa` criada e ativa.
- [x] **Passo 2: Configuração do Maven (`pom.xml`) e Estrutura de Pastas**
  - Criado o `pom.xml` com Spring Boot Starter Parent 3.3.5, `spring-boot-starter-data-jpa` e `mysql-connector-j`.
  - Pastas ajustadas para o padrão oficial: `src/main/java/br/com/devpatrick/controlefinanceiro` e `src/main/resources`.
- [x] **Passo 3: Configuração do Banco (`application.properties`)**
  - Configurados URL JDBC, usuário, senha, driver MySQL e `ddl-auto=update` no `application.properties`.
  - Aposentado o antigo `ConnectionFactory.java`.
- [x] **Passo 4: Mapeamento Objeto-Relacional (Entidades JPA)**
  - `Usuario`: anotado com `@Entity`, `@Table(name = "usuarios")`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)` e `@OneToOne(mappedBy = "titular")`.
  - `Conta`: anotada com `@Entity`, `@Table(name = "contas")`, `@Id`, `@GeneratedValue` e `@OneToOne @JoinColumn(name = "usuario_id")`.
- [x] **Passo 5: Repositórios Spring Data JPA**
  - `UsuarioRepository` e `ContaRepository` transformados em interfaces herdando de `JpaRepository`.
  - Query Methods criados: `findByCpf(String cpf)`, `findByNumeroConta(int numeroConta)` e `findByTitularId(int titularId)`.
- [x] **Passo 6: Adaptação dos Services e Inicialização da Aplicação**
  - `UsuarioService` e `ContaService` anotados com `@Service` e injeção com `@Autowired`.
  - `Menu` anotado com `@Component`.
  - Criada a classe `ControleFinanceiroApplication` com `@SpringBootApplication` e `CommandLineRunner`.
  - **Build com Maven:** `BUILD SUCCESS` (compilação limpa de todas as 8 classes).

---

## 📝 Registro de Sessões e Progresso
### Sessão 1 (19/10/2026):
- Alinhamento da linha de aprendizado e criação da pasta `logs/`.
- Criação da branch `feat/spring-boot-jpa`.
- Migração completa de Java puro / JDBC para Spring Boot 3 + Spring Data JPA.
- Compilação do Maven validada com sucesso (`BUILD SUCCESS`).
