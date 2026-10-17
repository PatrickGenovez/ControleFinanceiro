package repository;

import java.util.ArrayList;
import java.util.List;

import Model.Conta;
import Model.Usuario;
import database.ConnectionFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaRepository {

    // Salvar uma nova conta
    public void salvarConta(Conta conta) {
            
        String sql = "INSERT INTO contas (numero_conta, saldo, usuario_id) VALUES (?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, conta.getNumeroConta());
            stmt.setBigDecimal(2, conta.getSaldo());
            stmt.setInt(3, conta.getTitular().getId()); // Pega o ID do usuáro dono da conta

            stmt.executeUpdate();

        } catch(SQLException e){
            throw new RuntimeException("Erro ao salvar conta no banco de dados: " + e.getMessage());
        }

    }

    // Buscar conta por usuário
    public Conta buscarPorUsuarioId(int usuarioId, Usuario titular) {
        String sql = "SELECT id, numero_conta, saldo FROM contas WHERE usuario_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int numeroConta = rs.getInt("numero_conta");
                    BigDecimal saldo = rs.getBigDecimal("saldo");

                    // Monta o objeto Conta com os dados do MySQL:
                    Conta conta = new Conta(numeroConta, titular);
                    conta.setSaldo(saldo);
                    return conta;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar conta do usuário: " + e.getMessage());
        }

        return null; // Não encontrou conta para esse usuário
    }

    // Atualizar saldo no banco de dados
    public void atualizarSaldo(Conta conta) {
        String sql = "UPDATE contas SET saldo = ? WHERE numero_conta = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBigDecimal(1, conta.getSaldo());
            stmt.setInt(2, conta.getNumeroConta());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar saldo no banco de dados: " + e.getMessage());
        }
    }

    // Listar todas as contas
    public List<Conta> listarContas() {
        List<Conta> lista = new ArrayList<>();
        String sql = "SELECT id, numero_conta, saldo FROM contas";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int numeroConta = rs.getInt("numero_conta");
                BigDecimal saldo = rs.getBigDecimal("saldo");

                Conta conta = new Conta(numeroConta, null);
                conta.setSaldo(saldo);
                lista.add(conta);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar contas: " + e.getMessage());
        }

        return lista;
    }
}
    