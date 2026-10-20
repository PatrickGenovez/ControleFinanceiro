# 📘 Fase 01 — Fundamentos Java, POO, Camadas e JDBC Puro

**Período:** Outubro/2026  
**Status:** ✅ Concluída e mesclada na `main` (`PR #1` e `PR #2`)

---

## 🎯 Objetivos Concluídos
1. **Modelagem Orientada a Objetos (POO):**
   - Criação da classe `Usuario` (`id`, `nome`, `idade`, `email`, `cpf`, vínculo com `Conta`).
   - Criação da classe `Conta` (`numeroConta`, `saldo` usando `BigDecimal`, vínculo com `titular`).
   - Uso correto de tipos financeiros: `BigDecimal` para evitar problemas de precisão de ponto flutuante (`Double`/`Float`).

2. **Arquitetura em Camadas:**
   - **Model:** Representação dos dados do domínio.
   - **Service:** Regras de negócio (`UsuarioService`, `ContaService`). Validações de saldo suficiente, depósito positivo e login.
   - **Repository:** Responsabilidade única de acesso a dados (`UsuarioRepository`, `ContaRepository`).
   - **Menu/Main:** Interface em modo console com navegação interativa via `Scanner`.

3. **Persistência com MySQL & JDBC Puro:**
   - Criação do banco de dados `controle_financeiro`.
   - Conexão manual via `DriverManager` em `ConnectionFactory.java`.
   - Implementação de consultas e inserções usando `PreparedStatement` e `ResultSet`.
   - Obtenção do ID autoincremento gerado pelo MySQL com `Statement.RETURN_GENERATED_KEYS`.
   - Fechamento automático de recursos com `try-with-resources`.

---

## 💡 Principais Lições Aprendidas
- **Por que usamos `BigDecimal`?** O tipo primitivo `double` tem imprecisão de arredondamento em cálculos monetários. O `BigDecimal` garante exatidão matemática.
- **Por que `PreparedStatement` em vez de `Statement` puro?** Previne ataques de **SQL Injection** e permite passagem segura de parâmetros com `?`.
- **Por que camadas separadas?** O `Menu` cuida apenas da interação com o usuário; o `Service` das regras (ex: não permitir saldo negativo); o `Repository` apenas de falar com o MySQL.

---

## 🗄️ Tabelas Criadas no MySQL
- `usuarios` (`id INT AUTO_INCREMENT PRIMARY KEY`, `nome`, `idade`, `email`, `cpf UNIQUE`)
- `contas` (`id INT AUTO_INCREMENT PRIMARY KEY`, `numero_conta INT UNIQUE`, `saldo DECIMAL(15,2)`, `usuario_id INT`, chave estrangeira para `usuarios(id)`)
