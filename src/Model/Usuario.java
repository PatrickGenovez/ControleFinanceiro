package Model;

public class Usuario {
    private int id;
    private String name;
    private int age;
    private String email;
    private int cpf;

    // Construtores


    public Usuario() {
    }

    public Usuario(String name, int age, String email, int cpf) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.cpf = cpf;
    }

    // Métodos
    public void cadastrar(){
        if(!this.email.contains("@")){
            System.out.println("Inválido");
        }
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
