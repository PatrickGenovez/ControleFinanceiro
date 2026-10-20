package br.com.devpatrick.controlefinanceiro.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_conta", unique = true, nullable = false)
    private int numeroConta;

    private BigDecimal saldo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario titular;

    // Construtores
    public Conta() {
    }

    public Conta(int numeroConta, Usuario titular) {
        this.numeroConta = numeroConta;
        this.saldo = BigDecimal.ZERO;
        this.titular = titular;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Conta Nº: " + numeroConta + 
               "\nTitular: " + (titular != null ? titular.getName() : "Sem titular") + 
               "\nSaldo: " + String.format("R$ %.2f", saldo);
    }    
}
