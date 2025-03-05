
package Repository;

import java.util.List;
import model.Conta;
import java.util.ArrayList;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Repositorio {
    
    
    
    private final List <Conta> Contas = new ArrayList <>(); // lista que vai guardar as contas criadas
    
    
    
    public void adicionarContaCorrente (ContaCorrente conta){
        
        Contas.add(conta);
    }
    
    public void adicionarContaPoupanca (ContaPoupanca conta){
        
        Contas.add(conta);
    }
    
    public void MostrarContas (){
        
        for (Conta conta : Contas){ // para cada conta na lista contas exibe os dados
            System.out.println(conta.exibirDados());
            System.out.println("------------------");
            
        }
    }
    
}
