
package model;


import model.Enums.MensagemOperacao;
import model.Enums.TipoConta;

public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(){
       super("", 0.0, 0, TipoConta.CORRENTE);
    }
    
    public ContaPoupanca (String titular, double saldo, int numConta, TipoConta tipoConta){
        super (titular, saldo, numConta, tipoConta);
        
       
    }
    
    
    public void resgatar (double valor, ContaCorrente contaCorrente){ // tira da conta poupanca e manda pra conta corrente
        if (valor > 0 && valor <= getSaldo()){ // verifica se o valor é maior que zero e se está dentro do valor do saldo
            double saldoAtual = getSaldo();
            saldoAtual -= valor;
            setSaldo(saldoAtual);
            contaCorrente.depositar(valor);
            
            System.out.println(MensagemOperacao.RESGATE_SUCESSO.getMensagem());
        }else{
            System.out.println(MensagemOperacao.VALOR_INVALIDO.getMensagem());
        }
        
    }
   
}
