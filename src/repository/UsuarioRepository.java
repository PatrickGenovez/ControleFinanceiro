package repository;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public void salvarUsuario(Usuario usuario){
        this.listaUsuarios.add(usuario);
    }
    
    public List<Usuario> listarUsuarios(){
        return this.listaUsuarios;
    }

    public Usuario buscarPorCpf(String cpf){
        for(Usuario u : listaUsuarios){
            if(u.getCpf().equals(cpf)){
                return u;
            } else {
                System.out.println("não encontrado!");
            }
        
        }
        return null;
    }
    
}