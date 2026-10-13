package Model;

public class Conta {
    private int numeroConta;
    private double saldo;
    private Usuario titular;

    // Construtores
    private Conta(){

    }

    public Conta(int numeroConta, Usuario titular) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.titular = titular;
    }


    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
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
