package Model;

import java.math.BigDecimal;
import java.util.Scanner;
import repository.UsuarioRepository;

public class Menu {
    private Scanner scan = new Scanner(System.in);
    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    // Ponto de entrada do Menu (inicia todo o fluxo do sistema)
    public void iniciar() {
        int operacao;

        do {
            menuPrincipal();
            operacao = scan.nextInt();
            scan.nextLine();

            switch (operacao) {
                case 1:
                    cadastrarUsuario();
                    break;

                case 2:
                    listarUsuarios();
                    break;

                case 3:
                    fazerLogin();
                    break;

                case 0:
                    System.out.println("Fechando programa!!!");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }

        } while (operacao != 0);

        System.out.println("Programa finalizado!");
    }

    // Exibe as opções do Menu Principal
    public void menuPrincipal() {
        System.out.println("====== Controle Financeiro ======");
        System.out.println("[ 1 ] - Cadastrar Usuário");
        System.out.println("[ 2 ] - Listar Usuários");
        System.out.println("[ 3 ] - Fazer Login");
        System.out.println("[ 0 ] - Sair");
        System.out.print("Escolha a operação: ");
    }

    // Ações do Menu Principal
    private void cadastrarUsuario() {
        System.out.println("\n--- Cadastro de Usuário ---");
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
        
        // Cria a Conta e já vincula ao usuário
        int numeroConta = usuarioRepository.listarUsuarios().size() + 1;
        Conta novaConta = new Conta(numeroConta, novoUsuario);
        novoUsuario.setConta(novaConta);

        usuarioRepository.salvarUsuario(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private void listarUsuarios() {
        System.out.println("\n--- Lista de Usuários ---");
        if (usuarioRepository.listarUsuarios().isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (Usuario u : usuarioRepository.listarUsuarios()) {
            u.listarUsuarios();
            System.out.println("-------------------------");
        }
    }

    private void fazerLogin() {
        System.out.println("\n--- Login ---");
        System.out.print("Digite seu CPF: ");
        String cpfLogin = scan.nextLine();

        Usuario usuarioLogado = usuarioRepository.buscarPorCpf(cpfLogin);

        if (usuarioLogado == null) {
            System.out.println("Usuário não encontrado, se cadastre!");
        } else {
            System.out.println("Usuário logado com sucesso!");
            menuDaConta(usuarioLogado); // Abre o menu da conta daquele usuário
        }
    }

    // Menu da Conta do Usuário Logado
    public void menuDaConta(Usuario usuarioLogado) {
        int operacaoConta;

        do {
            System.out.println("\n=================================");
            System.out.println("Bem-Vindo(a), " + usuarioLogado.getName() + "!");
            System.out.println("[ 1 ] - Verificar Saldo");
            System.out.println("[ 2 ] - Adicionar Receita");
            System.out.println("[ 3 ] - Adicionar Despesa");
            System.out.println("[ 0 ] - Sair/Deslogar");
            System.out.print("Escolha a opção: ");

            operacaoConta = scan.nextInt();
            scan.nextLine();

            switch (operacaoConta) {
                case 1:
                    System.out.println("===============");
                    System.out.println("Saldo atual: R$ " + usuarioLogado.getConta().getSaldo());
                    break;

                case 2:
                    System.out.println("===============");
                    System.out.print("Valor da Receita: ");
                    BigDecimal receitaAdd = scan.nextBigDecimal();
                    scan.nextLine();

                    BigDecimal saldoAposReceita = usuarioLogado.getConta().getSaldo().add(receitaAdd);
                    usuarioLogado.getConta().setSaldo(saldoAposReceita);

                    System.out.println("Receita Cadastrada com sucesso!");
                    System.out.println("Novo saldo: R$ " + saldoAposReceita);
                    break;

                case 3:
                    System.out.println("===============");
                    System.out.print("Valor da Despesa: ");
                    BigDecimal despesaAdd = scan.nextBigDecimal();
                    scan.nextLine();

                    BigDecimal saldoAtual = usuarioLogado.getConta().getSaldo();

                    // Verifica se tem saldo suficiente
                    if (saldoAtual.compareTo(despesaAdd) >= 0) {
                        BigDecimal saldoAposDespesa = saldoAtual.subtract(despesaAdd);
                        usuarioLogado.getConta().setSaldo(saldoAposDespesa);
                        System.out.println("Despesa Cadastrada com sucesso!");
                        System.out.println("Novo saldo: R$ " + saldoAposDespesa);
                    } else {
                        System.out.println("Saldo insuficiente! Você possui apenas R$ " + saldoAtual);
                    }
                    break;

                case 0:
                    System.out.println("Deslogando da conta...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }

        } while (operacaoConta != 0); // Continua no menu da conta até o usuário digitar 0
    }
}
