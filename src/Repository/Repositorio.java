
package Repository;

import java.util.List;
import model.Conta;
import java.util.ArrayList;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Repositorio {
    
    
    
    private static final List <Conta> Contas = new ArrayList <>(); // lista que vai guardar as contas criadas
    
    
    
    public static void adicionarContaCorrente (ContaCorrente cc){
        
        Contas.add(cc);
    }
    
    public static void adicionarContaPoupanca (ContaPoupanca cp){
        
        Contas.add(cp);
    }
    
    public static void MostrarContas (){
        
         if (Contas.isEmpty()) {
            System.out.println("Não há contas cadastradas.");
        } else {
            for (Conta conta : Contas) { // para cada conta na lista contas, exibe os dados
                System.out.println(conta.exibirDados());
                System.out.println("------------------");
            }
            
        }
    }
    
}
