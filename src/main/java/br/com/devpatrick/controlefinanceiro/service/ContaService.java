package br.com.devpatrick.controlefinanceiro.service;

import br.com.devpatrick.controlefinanceiro.model.Conta;
import br.com.devpatrick.controlefinanceiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public BigDecimal consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

    public boolean adicionarReceita(Conta conta, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            conta.setSaldo(conta.getSaldo().add(valor));
            contaRepository.save(conta); // JPA cuida do UPDATE no MySQL automaticamente!
            System.out.println("Receita adicionada com sucesso!");
            return true;
        } else {
            System.out.println("Tente novamente, valor negativo!");
            return false;
        }
    }

    public boolean adicionarDespesa(Conta conta, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            if (conta.getSaldo().compareTo(valor) >= 0) {
                conta.setSaldo(conta.getSaldo().subtract(valor));
                contaRepository.save(conta); // JPA cuida do UPDATE no MySQL automaticamente!
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
