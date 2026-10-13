package Model;

public class Usuario {
    private int id;
    private String name;
    private int age;
    private String email;
    private String cpf;
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

    // Getters e Setterss
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
    
}
