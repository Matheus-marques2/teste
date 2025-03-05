
package model;


import model.Enums.MensagemOperacao;
import model.Enums.TipoConta;

public class ContaPoupanca extends Conta {
    
    
    
    public ContaPoupanca (String titular, double saldo, int numConta, TipoConta tipoConta){
        super (titular, saldo, numConta, tipoConta);
        
       
    }
    
    
    public void resgatar (double valor, ContaCorrente contaCorrente){ // tira da conta poupanca e manda pra conta corrente
        if (valor > 0 && valor <= this.saldo){ // verifica se o valor é maior que zero e se está dentro do valor do saldo
            this.saldo -= valor;
            contaCorrente.depositar(valor);
            
            System.out.println(MensagemOperacao.RESGATE_SUCESSO.getMensagem());
        }else{
            System.out.println(MensagemOperacao.VALOR_INVALIDO.getMensagem());
        }
        
    }
   
}
