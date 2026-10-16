package service;


import Model.Conta;
import Model.Menu;
import Model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {

    private UsuarioRepository usuarioRepository = new UsuarioRepository();


    public boolean cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.buscarPorCpf(usuario.getCpf()) == null){
            // Verifica se existe algum CPF cadastrado antes de criar uma conta
            int numeroConta = usuarioRepository.listarUsuarios().size() + 1;
            Conta novaConta = new Conta(numeroConta, usuario);
            usuario.setConta(novaConta);
            
            usuarioRepository.salvarUsuario(usuario);
            return true;
            
        } else {
            return false;
        }
    }


    public void listarUsuarios() {
        if(usuarioRepository.listarUsuarios().isEmpty()){
            System.out.println("Nenhum usuário cadastrado!");
        } else {
            for (Usuario u : usuarioRepository.listarUsuarios()) {
                System.out.println("---------------");
                System.out.println("Nome: " + u.getName());
                System.out.println("Idade: " + u.getAge());
                System.out.println("Email: " + u.getEmail());
            }
        }
    }

    public Usuario fazerLogin(String cpf){
        return usuarioRepository.buscarPorCpf(cpf);
    }
}