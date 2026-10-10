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
            System.out.println("[ 2 ] - Listar Usuários");
            System.out.println("[ 3 ] - Remover Usuários");
            System.out.println("[ 4 ] - Adicionar dispesa");
            System.out.println("[ 0 ] - Sair");
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

                    int cont = listaUsuarios.size();
                    novoUsuario.setId(cont);

                    System.out.println("Usuário cadastrado!");

                    break;

                case 2:
                    System.out.println("Listando...");
                    for (Usuario u : listaUsuarios){
                        u.listarUsuarios();
                        System.out.println("----------");
                    }

                    break;
                case 3:
                    System.out.println("Removendo...");

                    break;

                case 4:
                    System.out.println("Safado");
                    break;

                case 0:
                    System.out.println("Fechando programa!!!");
                    break;

                default:
                    System.out.println("Tente novamente!");
            }

        } while (operacao != 0);
        {
            System.out.println("Programa finalizado!!!");

        }
    }
}