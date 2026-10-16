package service;

import java.math.BigDecimal;

import Model.Conta;
import repository.ContaRepository;
import repository.UsuarioRepository;

public class ContaService {

    ContaRepository contaRepository = new ContaRepository();

    public BigDecimal consultarSaldo(Conta conta){
        return conta.getSaldo();
    }
    
    public boolean adicionarReceita(Conta conta, BigDecimal valor) {
        // Verifica se o valor é positivo (Maior que zero)

        // Lembrete Patrick -- O compareTo é usado para comparar valores de BigDecimal
        if(valor.compareTo(BigDecimal.ZERO) > 0){

            // Calcula o novo saldo e atualiza a conta

            conta.setSaldo(conta.getSaldo().add(valor)); 
            System.out.println("Receita adicionada com sucesso!");

            return true; // Deu certo

        } else {
            System.out.println("Tente novamente, valor negativo!");

            return false; // Deu errado
        }
    }

    public boolean adicionarDespesa(Conta conta, BigDecimal valor) {

        // 1º Valida se o valor digitado é maior que zero! 

        if(valor.compareTo(BigDecimal.ZERO) > 0) {
            
            // 2º Valida se tem saldo suficiente

            if(conta.getSaldo().compareTo(valor) >= 0) {
                conta.setSaldo(conta.getSaldo().subtract(valor));
                System.out.println("Despesa adicionada com sucesso!");
                return true;
            } else {
                System.out.println("Erro tente novamente!");
                return false;
            }
        } else {
            System.out.println("Impossível despesa com valor negativo!");
            return false;
        }

    }
}
