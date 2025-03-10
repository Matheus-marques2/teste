
package controller;

import java.util.Scanner;
import model.ContaCorrente;
import model.ContaPoupanca;
import Repository.Repositorio;
import model.Cliente;


public class Operacoes {
       
    Banco b = new Banco();
    Repositorio r = new Repositorio();  
    Scanner scan = new Scanner(System.in);
     
    public void menu(){
        
        Cliente cliente = null;
        
        while(true){
            System.out.println("------------------------------------------------------");
            System.out.println("-------------Bem vindos a nossa Agência---------------");
            System.out.println("------------------------------------------------------");
            System.out.println("***** Selecione uma operação que deseja realizar *****");
            System.out.println("------------------------------------------------------");
            System.out.println("|   Opção 1 - Criar conta   |");
            System.out.println("|   Opção 2 - Depositar     |");
            System.out.println("|   Opção 3 - Sacar         |");
            System.out.println("|   Opção 4 - Aplicar       |");
            System.out.println("|   Opção 5 - Resgatar      |");
            System.out.println("|   Opção 6 - Listar        |");
            System.out.println("|   Opção 7 - Sair          |");

            int opcao = scan.nextInt();
        
            switch (opcao){
                case 1 -> {
                    cliente = b.criarCliente(); 
                    
    
                }                            
                case 2 -> {
                    if (cliente == null){
                        System.out.println("cliente inexistente, crie uma conta.");
                    }
                    if (cliente.getContaCorrente() != null) {
                    System.out.println("Digite o valor a ser depositado: ");
                    double valor = scan.nextDouble();
                    cliente.getContaCorrente().depositar(valor);
                    } else {
                    System.out.println("Cliente sem uma conta corrente.");
                    }                   
                }               
            
                case 3 -> {
                    if (cliente == null){
                        System.out.println("cliente inexistente, crie uma conta.");
                    }
                    if (cliente.getContaCorrente() != null) {
                    System.out.println("Digite o valor a ser sacado: ");
                    double valor = scan.nextDouble();
                    cliente.getContaCorrente().sacar(valor);
                    } else {
                    System.out.println("Cliente sem uma conta corrente.");
                    }
                }
            
                case 4 -> {
                    if (cliente == null){
                        System.out.println("cliente inexistente, crie uma conta.");
                    }
                    if (cliente.getContaCorrente() != null && cliente.getContaPoupanca() != null) {
                    System.out.println("Digite o valor a ser aplicado: ");
                    double valor = scan.nextDouble();
                    cliente.getContaCorrente().aplicar(valor, cliente.getContaPoupanca());
                    } else {
                    System.out.println("Cliente sem uma conta corrente ou uma conta poupança.");
                    }
                }
            
                case 5 -> {
                    if (cliente == null){
                        System.out.println("cliente inexistente, crie uma conta.");
                    }
                    if (cliente.getContaPoupanca() != null && cliente.getContaCorrente() != null) {
                    System.out.println("Digite o valor a ser resgatado: ");
                    double valor = scan.nextDouble();
                    cliente.getContaPoupanca().resgatar(valor, cliente.getContaCorrente());
                    } else {
                    System.out.println("Cliente sem uma conta corrente ou uma conta poupança.");
                    }
                }
            
                case 6 -> r.MostrarContas();
            
                case 7 -> {
                    System.out.println("Você saiu do menu");
                    return;
                }           
                    
                default ->  System.out.println("opção inválida");
                
        }
         
                
            
                
        }
    }
}
