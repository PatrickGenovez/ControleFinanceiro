package main;

import Model.Menu;
import Model.Usuario;
import repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        int operacao;

        do {
            menu.menuPrincipal();
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
                    usuarioRepository.salvarUsuario(novoUsuario);


                    System.out.println("Usuário cadastrado!");

                    break;

                case 2:
                    System.out.println("Listando...");
                    for(Usuario u : usuarioRepository.listarUsuarios()){
                        u.listarUsuarios();
                        System.out.println("---------------");
                    }

                    break;
                case 3:
                    System.out.println("Digite seu CPF: ");
                    String cpfLogin = scan.nextLine();

                    Usuario usuarioLogado = usuarioRepository.buscarPorCpf(cpfLogin);

                    if (usuarioLogado == null){
                        System.out.println("Impossível fazer login, se cadastre!");
                    } else { 
                        System.out.println("Usuário logado!");
                        menu.menuDaConta(usuarioLogado, scan);
                    }
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