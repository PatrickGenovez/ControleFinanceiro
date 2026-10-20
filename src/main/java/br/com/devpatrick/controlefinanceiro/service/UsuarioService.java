package br.com.devpatrick.controlefinanceiro.service;

import br.com.devpatrick.controlefinanceiro.model.Conta;
import br.com.devpatrick.controlefinanceiro.model.Usuario;
import br.com.devpatrick.controlefinanceiro.repository.ContaRepository;
import br.com.devpatrick.controlefinanceiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByCpf(usuario.getCpf()).isEmpty()) {
            int numeroConta = (int) usuarioRepository.count() + 1;
            Conta novaConta = new Conta(numeroConta, usuario);
            usuario.setConta(novaConta);

            usuarioRepository.save(usuario);
            contaRepository.save(novaConta);
            return true;
        } else {
            return false;
        }
    }

    public void listarUsuarios() {
        List<Usuario> lista = usuarioRepository.findAll();
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for (Usuario u : lista) {
                System.out.println("---------------");
                System.out.println("Nome: " + u.getName());
                System.out.println("Idade: " + u.getAge());
                System.out.println("Email: " + u.getEmail());
            }
        }
    }

    public Usuario fazerLogin(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf).orElse(null);
        if (usuario != null) {
            // Busca a conta vinculada ao usuário se existir
            contaRepository.findByTitularId(usuario.getId()).ifPresent(usuario::setConta);
        }
        return usuario;
    }
}