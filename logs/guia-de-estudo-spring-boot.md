# 📘 Guia de Estudo — Spring Boot & Spring Data JPA

**Projeto ControleFinanceiro — Patrick Genovez | Outubro 2026**

---

## 1. Injeção de Dependências (o mais importante!)

> Em vez de criar objetos com `new`, o Spring cria e entrega para você automaticamente.

### Anotações que você precisa saber:

| Anotação | Onde usar | O que faz |
|---|---|---|
| `@Component` | Classes genéricas | Registra a classe no Spring |
| `@Service` | Classes de regra de negócio | Igual ao @Component, mas semântico |
| `@Repository` | Interfaces de acesso a dados | Igual ao @Component, mas para banco |
| `@Autowired` | Campos ou construtores | Pede ao Spring para injetar o objeto |

### Exemplo prático do projeto:

```java
// ANTES (Java puro) — você criava na mão:
private ContaRepository contaRepository = new ContaRepository();

// DEPOIS (Spring) — o Spring entrega pronto:
@Autowired
private ContaRepository contaRepository;
```

---

## 2. Anotações JPA (Mapeamento de Entidades)

> Anotações que transformam uma classe Java em uma tabela do banco de dados, sem escrever SQL.

| Anotação | O que faz |
|---|---|
| `@Entity` | Marca a classe como uma tabela no banco |
| `@Table(name = "...")` | Define o nome da tabela no MySQL |
| `@Id` | Marca o campo como chave primária |
| `@GeneratedValue(strategy = GenerationType.IDENTITY)` | ID gerado automaticamente (AUTO_INCREMENT) |
| `@Column(nullable, unique)` | Configura restrições da coluna |
| `@OneToOne` | Relacionamento 1 para 1 |
| `@JoinColumn(name = "...")` | Define a coluna de chave estrangeira |

### Exemplo prático do projeto:

```java
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String cpf;
}
```

---

## 3. JpaRepository & Query Methods

> Substituiu ~200 linhas de código JDBC manual por ~5 linhas.

### Métodos que vêm prontos (grátis):

| Método | SQL equivalente |
|---|---|
| `save(entidade)` | INSERT ou UPDATE (automático) |
| `findAll()` | SELECT * FROM tabela |
| `findById(id)` | SELECT * WHERE id = ? |
| `count()` | SELECT COUNT(*) FROM tabela |
| `delete(entidade)` | DELETE FROM tabela WHERE id = ? |

### Query Methods (métodos personalizados):

Você só escreve o **nome do método** e o Spring gera o SQL:

```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Spring gera: SELECT * FROM usuarios WHERE cpf = ?
    Optional<Usuario> findByCpf(String cpf);
}

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    // Spring gera: SELECT * FROM contas WHERE usuario_id = ?
    Optional<Conta> findByTitularId(int titularId);
}
```

---

## 4. application.properties

> O arquivo que substituiu o `ConnectionFactory.java`. Configura a conexão com o banco.

```properties
# Conexão com o MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/controle_financeiro
spring.datasource.username=root
spring.datasource.password=SuaSenha

# Hibernate atualiza as tabelas automaticamente
spring.jpa.hibernate.ddl-auto=update

# Mostra os SQLs gerados no console (bom para aprender)
spring.jpa.show-sql=true
```

---

## 5. @SpringBootApplication + CommandLineRunner

> A classe principal que inicializa todo o Spring Boot.

```java
@SpringBootApplication  // Liga tudo: scan, config, conexão
public class ControleFinanceiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleFinanceiroApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(Menu menu) {
        return args -> { menu.iniciar(); };
    }
}
```

- `@SpringBootApplication` faz 3 coisas: auto-configuração, scan de componentes e habilita configuração.
- `CommandLineRunner` executa código assim que o Spring termina de inicializar.

---

## 📌 Ordem Recomendada de Estudo

1. **Injeção de Dependências** — sem entender isso, nada faz sentido
2. **Anotações JPA** — conecta Java com banco de dados
3. **JpaRepository + Query Methods** — o que você mais usa no dia a dia
4. **application.properties** — rápido de aprender
5. **@SpringBootApplication** — rápido de aprender
