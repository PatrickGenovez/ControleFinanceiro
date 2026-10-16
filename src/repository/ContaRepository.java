package repository;

import java.util.ArrayList;
import java.util.List;

import Model.Conta;

public class ContaRepository {

    private List<Conta> contas = new ArrayList<>();

    // Salvar uma nova conta
    public void salvarConta(Conta conta) {
        this.contas.add(conta);
    }

    // Buscar conta por número
    public Conta buscarPorNumero(int numeroConta){
        for(Conta c : this.contas) {
            if(c.getNumeroConta() == numeroConta){
                return c;
            }
        }
        return null;
    }

    // Listar todas as contas
    public List<Conta> listarContas() {
        return this.contas;
    }
    
}
    