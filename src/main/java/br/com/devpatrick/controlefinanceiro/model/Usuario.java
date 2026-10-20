package br.com.devpatrick.controlefinanceiro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "idade")
    private int age;

    private String email;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToOne(mappedBy = "titular", cascade = CascadeType.ALL)
    private Conta conta;

    // Construtores
    public Usuario() {
    }

    public Usuario(String name, int age, String email, String cpf) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
    }

    // Métodos
    public void listarUsuarios() {
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getName());
        System.out.println("Idade: " + getAge());
        System.out.println("Email: " + getEmail());
        System.out.println("CPF: " + getCpf());
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Nome: " + name + " | Idade: " + age + " | Email: " + email + " | CPF: " + cpf;
    }
}
