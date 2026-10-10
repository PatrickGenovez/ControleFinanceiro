package main;

import Model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        List<Usuario> listaUsuarios = new ArrayList<>();

        int operacao;

        do {
            System.out.println("====== Controle Financeiro ======");
            System.out.println("[ 1 ] - Cadastrar Usuário");
            System.out.println("[ 2 ] - Remover usuário");
            System.out.println("[ 3 ] - Listar Usuários");
            System.out.println("[ 3 ] - Adicionar dispesa");
            System.out.print("Escolha a operação: ");
            operacao = scan.nextInt();
            scan.nextLine();

            switch (operacao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scan.nextLine();

                    System.out.print("Idade: ");
                    int idade = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Email: ");
                    String email = scan.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scan.nextLine();

                    Usuario novoUsuario = new Usuario(nome, idade, email, cpf);
                    listaUsuarios.add(novoUsuario);

                    System.out.println("Usuário cadastrado!");

                    break;

                case 2:
                    System.out.println("Digite o CPF do usuário que deseja remover: ");
                    int removerUsuario = scan.nextInt();
                    scan.nextLine();

                    break;

            }

        } while (operacao != 0);
        {

        }
    }
}