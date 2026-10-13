package Model;

import java.util.Scanner;
import java.math.BigDecimal;

public class Menu {
    Scanner scan = new Scanner(System.in);
    

    // Menu principal
    public void menuPrincipal(){
        System.out.println("====== Controle Financeiro ======");
        System.out.println("[ 1 ] - Cadastrar Usuário");
        System.out.println("[ 2 ] - Listar Usuários");
        System.out.println("[ 3 ] - Fazer login");
        System.out.println("[ 0 ] - Sair");
        System.out.print("Escolha a operação: ");


    }
    

    // Menu Da Conta
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
                System.out.println("Valor da Receita: ");
                BigDecimal receitaAdd = scan.nextBigDecimal();
                scan.nextLine();

                // Aqui ele vai somar o saldo atual com a receita adicionada
                BigDecimal res = usuarioLogado.getConta().getSaldo().add(receitaAdd);
                usuarioLogado.getConta().setSaldo(res);


                System.out.println("Receita Cadastrada!");
                break;


            case 3:
                System.out.println("===============");
                System.out.println("Valor da despesa: ");
                BigDecimal despesaAdd = scan.nextBigDecimal();
                scan.nextLine();
                
                // Aqui ele vai subtrair o saldo atual com a despesa adicionada
                BigDecimal res = usuarioLogado.getConta().getSaldo().subtract(despesaAdd);
                usuarioLogado.getConta().setSaldo(res);
            
                System.out.println("Despesa Cadastrada!");
                break;
                
            case 0:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Valor incorreto,, tente novamente!");
                break;
        }
    }    
}
