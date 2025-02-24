
package view;

import controller.Repositorio;
import controller.banco;
import model.Cliente;
import model.ContaCorrente;
import model.ContaPoupanca;        

public class Principal {
    
    public static void main(String[] args) {
        
        Repositorio r = new Repositorio(); // pra ter acesso a lista e aos metodos do repositorio
        
        banco b = new banco(); // pra ter acesso aos metodos de banco
               
        
        Cliente c = b.criarCliente(); // criando novo cliente
        
        if (c != null){ // checagem para ver se o cliente existe, caso o contrário retorna a mensagem de erro
            
            System.out.println("Novo cliente criado com sucesso");
            
        }else {
            
            System.out.println("erro ao criar o cliente");
        }
        
            if (c.getContaCorrente() != null) { // verifica se o cliente criou conta corrente
            
                ContaCorrente cc = c.getContaCorrente();
                System.out.println("---------------");
                System.out.println(cc.exibirDados());
                System.out.println("---------------");
                
                r.adicionarContaCorrente(cc); // adiciona na lista
            
        }
        
             if (c.getContaPoupanca()!= null) { // verifica se o cliente criou conta poupanca
            
                 ContaPoupanca cp = c.getContaPoupanca(); 
                 System.out.println("---------------");
                 System.out.println(cp.exibirDados());
                 System.out.println("---------------");
                 
                 r.adicionarContaPoupanca(cp); // adiciona na lista
        }
             
        Cliente c2 = b.criarCliente();  
        
        if (c2 != null){ // checa se o cliente existe, caso o contrário retorna a mensagem de erro
            
            System.out.println("Novo cliente criado com sucesso");
            
        }else {
            
            System.out.println("erro ao criar o cliente");
        }
        
            if (c2.getContaCorrente() != null) { // verifica se o cliente criou conta corrente
            
                ContaCorrente cc = c2.getContaCorrente();
                System.out.println("---------------");
                System.out.println(cc.exibirDados());
                System.out.println("---------------");
                
                r.adicionarContaCorrente(cc);
            
        }
        
             if (c2.getContaPoupanca()!= null) { // verifica se o cliente criou conta poupanca
            
                 ContaPoupanca cp = c2.getContaPoupanca(); 
                 System.out.println("---------------");
                 System.out.println(cp.exibirDados());
                 System.out.println("---------------");
                 
                 r.adicionarContaPoupanca(cp);
        }
        
        // vê o saldo e deposita 1000
        System.out.println(c.getContaCorrente().getSaldo());
        c.getContaCorrente().depositar(1000);
        
        // vê o saldo depois do deposito e saca 200
        System.out.println(c.getContaCorrente().getSaldo());
        c.getContaCorrente().sacar(200);
        
        // transfere da conta corrente para conta poupanca
        c.getContaCorrente().aplicar(200, c2.getContaPoupanca());
        System.out.println(c.getContaCorrente().getSaldo());

        // transfere da conta poupanca para conta corrente
        c2.getContaPoupanca().resgatar(200, c.getContaCorrente());
        System.out.println(c.getContaCorrente().getSaldo());

              
        // exibe os dados das contas que estão na lista
        r.MostrarContas();
    }
}
