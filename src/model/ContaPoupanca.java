
package model;


public class ContaPoupanca extends Conta {
    
    
    public ContaPoupanca (String titular, double saldo, int numConta){
        super (titular, saldo, numConta);
    }
    
    public void resgatar (double valor, ContaCorrente contaCorrente){ // tira da conta poupanca e manda pra conta corrente
        if (valor > 0 && valor <= this.saldo){ // verifica se o valor é maior que zero e se está dentro do valor do saldo
            this.saldo -= valor;
            contaCorrente.depositar(valor);
            
            System.out.println("o valor de " + valor + " pela conta corrente");
        }else{
            System.out.println("valor digitado é inválido, tente novamente");
        }
        
    }
   
}
