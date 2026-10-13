package Model;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    
    public void menuPrincipal(){
        System.out.println("====== Controle Financeiro ======");
        System.out.println("[ 1 ] - Cadastrar Usuário");
        System.out.println("[ 2 ] - Listar Usuários");
        System.out.println("[ 3 ] - Fazer login");
        System.out.println("[ 0 ] - Sair");
        System.out.print("Escolha a operação: ");
    }
    
    public void menuDaConta(Usuario usuarioLogado, Scanner scan){
        System.out.println("===============");
        System.out.println("Bem-Vindo(a), "+ usuarioLogado.getName()+"!");
        System.out.println("[ 1 ] - Verificar saldo");
        System.out.println("[ 2 ] - Adicionar Receita");
        System.out.println("[ 3 ] - Adicionar Despesa");
        System.out.println("[ 0 ] - Sair/Deslogar");

        int operacaoConta = scan.nextInt();
        scan.nextLine();

        switch (operacaoConta) {
            case 1:
                System.out.println("===============");
                System.out.println("Saldo atual: R$" + usuarioLogado.getConta().getSaldo());
                break;

            case 2:
                System.out.println("===============");
                System.out.println("Adicionar valor: ");
                double receitaAdd = scan.nextDouble();
                scan.nextLine();

                usuarioLogado.getConta().setSaldo(receitaAdd);
                System.out.println("Receita Cadastrada!");
                break;

            default:
                break;
        }
    }    
}
