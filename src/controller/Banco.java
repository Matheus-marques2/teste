
package controller;
 import java.util.Random;
 import java.util.Scanner;
 import model.Cliente;
 import model.ContaCorrente;
 import model.ContaPoupanca;
 import model.Enums.TipoConta;
 import model.Enums.TipoTaxaSaque;
 import model.Enums.MensagemOperacao;
 import Repository.Repositorio;

public class Banco {
    
        Repositorio r = new Repositorio();
        Scanner scan = new Scanner (System.in);
                
        // metodo para criacao de cliente
        public Cliente criarCliente () {
            System.out.println("informe o nome do cliente: ");
            String nome  = scan.nextLine();
            
            Random random = new Random();
            int numContaCorrente = random.nextInt(9999); // cria um número aleátorio de 4 dígitos e já seta como número da conta
            int numContaPoupanca = random.nextInt(9999);
                                
            System.out.println("escolha um tipo de conta");
            System.out.println("digite 1 para conta corrente");
            System.out.println("digite 2 para conta poupanca");
            System.out.println("digite 3 para criar os dois tipos de conta");
            
            int escolha = scan.nextInt(); scan.nextLine(); // scan.nextLine() pra limpar buffer
            
            double saldoInicialCorrente = 0; // saldo inicial padrão é zero
            double saldoInicialPoupanca = 0;
            
            System.out.println("Deseja fazer um depósito inicial? (S/N)"); // pergunta se o cliente deseja ter um saldo inicial
            String resposta = scan.nextLine().toUpperCase(); // upper case para aceitar entradas em minúsculo 

            if (resposta.equals("S") && (escolha == 1 || escolha == 3)) {  
                System.out.println("Informe o saldo inicial para conta corrente: ");
                saldoInicialCorrente = scan.nextDouble(); scan.nextLine();
                
                if (saldoInicialCorrente < 0 ) { // verificador que não permite numero negativo
                    System.out.println(MensagemOperacao.SALDO_INICIAL_INVALIDO.getMensagem());
                    saldoInicialCorrente = 0;
                }      
            }
            
            if (resposta.equals("S") && (escolha == 2 || escolha == 3)) {  
                System.out.println("Informe o saldo inicial para conta poupanca: ");
                saldoInicialPoupanca = scan.nextDouble(); scan.nextLine();
                
                if (saldoInicialPoupanca < 0 ) { // verificador que não permite numero negativo
                    System.out.println(MensagemOperacao.SALDO_INICIAL_INVALIDO.getMensagem());
                    saldoInicialPoupanca = 0;
                }      
            }
            
            Cliente cliente = null;
            
            switch (escolha) {
                case 1 -> {
                    ContaCorrente cc = new ContaCorrente (nome, saldoInicialCorrente, numContaCorrente, TipoTaxaSaque.COMUM,  TipoConta.CORRENTE);
                    r.adicionarContaCorrente(cc);
                    cliente = new Cliente (nome, cc, null); // null pq nesse caso a conta poupanca n existe                   
                }
                case 2 -> {
                    ContaPoupanca cp = new ContaPoupanca (nome, saldoInicialPoupanca, numContaPoupanca, TipoConta.POUPANCA);
                    r.adicionarContaPoupanca(cp);
                    cliente = new Cliente (nome, null, cp); // null pq nesse caso a conta corrente n existe
                }
                case 3 -> {
                    ContaPoupanca cp = new ContaPoupanca (nome, saldoInicialPoupanca, numContaPoupanca, TipoConta.POUPANCA);
                    r.adicionarContaPoupanca(cp);
                    ContaCorrente cc = new ContaCorrente (nome, saldoInicialCorrente, numContaCorrente, TipoTaxaSaque.COMUM, TipoConta.CORRENTE);
                    r.adicionarContaCorrente(cc);
                    cliente = new Cliente (nome, cc, cp); // null pq nesse caso a conta corrente n existe
                }
                default -> { // caso digite algo diferente de 1 e 2
                    System.out.println(MensagemOperacao.VALOR_INVALIDO.getMensagem());
                     
                }
            }
            
            return cliente;
            
            
           
        }       
}
