
package controller;
 import java.util.Random;
 import java.util.Scanner;
 import model.Cliente;
 import model.ContaCorrente;
 import model.ContaPoupanca;
 

public class banco {
    
        Scanner scan = new Scanner (System.in);
                
        // metodo para criacao de cliente
        public Cliente criarCliente () {
            System.out.println("informe o nome do cliente: ");
            String nome  = scan.nextLine();
            
            Random random = new Random();
            int numConta = random.nextInt(9999); // cria um número aleátorio de 4 dígitos e já seta como número da conta
            
            System.out.println("escolha um tipo de conta");
            System.out.println("digite 1 para conta corrente");
            System.out.println("digite 2 para conta poupanca");
            
            int escolha = scan.nextInt(); scan.nextLine(); // scan.nextLine() pra limpar buffer
            
            double saldoInicial = 0; // saldo inicial padrão é zero
            
            System.out.println("Deseja fazer um depósito inicial? (S/N)"); // pergunta se o cliente deseja ter um saldo inicial
            String resposta = scan.nextLine().toUpperCase(); // upper case para aceitar entradas em minúsculo 

            if (resposta.equals("S")) {  
                System.out.println("Informe o saldo inicial: ");
                saldoInicial = scan.nextDouble(); scan.nextLine();
                
                if (saldoInicial < 0 ) { // verificador que não permite numero negativo
                    System.out.println("não é permitido começar uma conta com saldo negativo, o valor do saldo inicial será 0");
                    saldoInicial = 0;
                }      
            }
                           
            switch (escolha) {
                case 1 -> {
                    ContaCorrente cc = new ContaCorrente (nome, saldoInicial, numConta);
                    return new Cliente (nome, cc, null); // null pq nesse caso a conta poupanca n existe
                }
                case 2 -> {
                    ContaPoupanca cp = new ContaPoupanca (nome, saldoInicial, numConta);
                    return new Cliente (nome, null, cp); // null pq nesse caso a conta corrente n existe
                }
                default -> { // caso digite algo diferente de 1 e 2
                    System.out.println("opção digitada é inválida, tente novamente");
                    return null; 
                }
            }
           
                
            
            
           
        }       
}
