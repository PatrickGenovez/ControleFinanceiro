package Model;

import java.math.BigDecimal;

public class Conta {
    private int numeroConta;
    private BigDecimal saldo;
    private Usuario titular;

    // Construtores
    public Conta(){
        
    }

    public Conta(int numeroConta, Usuario titular) {
        this.numeroConta = numeroConta;
        this.saldo = BigDecimal.ZERO;
        this.titular = titular;
    }


    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public String toString(){
        return "Conta Nº: " + numeroConta + 
        "\nTitular: " + titular.getName() + 
        "\nSaldo: " + String.format("R$ %.2f", saldo);
    }    
}
