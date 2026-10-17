package repository;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioRepository {

    public void salvarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios (nome, idade, email, cpf) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                
                // Preecnher os 4 pontos de interrogação
                stmt.setString(1, usuario.getName());
                stmt.setInt(2, usuario.getAge());
                stmt.setString(3, usuario.getEmail());
                stmt.setString(4, usuario.getCpf());

                // Executa a inserção dos bancos
                stmt.executeUpdate();

                // Pega o ID automático que o MySql gerou para o usuário
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setId(rs.getInt(1));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao salvar usuário no banco de dados: " + e.getMessage());
            }
        
    }
    
    public List<Usuario> listarUsuarios(){
    List<Usuario> lista = new ArrayList<>(); // Precisa desse ArrayList para ele percorrer

    String sql = "SELECT id, nome, idade, email, cpf FROM usuarios";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            int idade = rs.getInt("idade");
            String email = rs.getString("email");
            String cpf = rs.getString("cpf");

            Usuario usuario = new Usuario(nome, idade, email, cpf);
            usuario.setId(id);
            lista.add(usuario);
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao listar usuários: " + e.getMessage());
    }

    return lista;
}


    public Usuario buscarPorCpf(String cpf){

    String sql = "SELECT id, nome, idade, email, cpf FROM usuarios WHERE cpf = ?";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Achou o usuário no MySQL! Extrai as colunas:
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String email = rs.getString("email");
                String cpfBanco = rs.getString("cpf");

                // Reconstrói o objeto Usuario:
                Usuario usuario = new Usuario(nome, idade, email, cpfBanco);
                usuario.setId(id);
                return usuario;
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar usuário por CPF: " + e.getMessage());
    }
    return null; // Não encontrou ninguém com esse CPF
    }    
}