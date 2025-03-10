
package model;


import model.Enums.TipoTaxaSaque;
import model.Enums.MensagemOperacao;
import model.Enums.TipoConta;

public class ContaCorrente extends Conta implements Tarifavel{ // ContaCorrente extends conta pq é subclasse de conta e implements Tarifavel pq é suscetivel às tarifas

    
   
    private TipoTaxaSaque tipoTaxaSaque;
    
    public ContaCorrente(){
       super("", 0.0, 0, TipoConta.CORRENTE);
    }
    
    public ContaCorrente(String titular, double saldo, int numConta,TipoTaxaSaque tipoTaxaSaque, TipoConta tipoConta) {
        super (titular, saldo, numConta, tipoConta);
        
        this.tipoTaxaSaque = tipoTaxaSaque;
        
    }

  

    
    
    @Override
    public void aplicarTarifaMensal(double tarifa) { // metodo de tarifa mensal
        if (tarifa > 0){
            this.saldo -= tarifa;
            System.out.println(MensagemOperacao.TARIFA_APLICADA.getMensagem() + "R$" + tarifa);
        }
        
        
    }

    @Override
    public void cobrarTaxa(double valor) { // metodo de cobrar taxa única
        if (valor > 0){
            this.saldo -= valor;
            System.out.println("Cobrança de: R$" + valor + " foi aplicada.");
        }
    }
    
    @Override
    public double sacar (double valor) { // metodo de saque sobrescrito, foi preciso adicionar taxa de saque
        if (valor > 0 && valor + tipoTaxaSaque.getValor() <= saldo){ // verifica se o valor é positivo e se é menor ou igual ao saldo
           saldo -= (valor + tipoTaxaSaque.getValor()); 
           System.out.println(MensagemOperacao.SAQUE_SUCESSO.getMensagem() + "(" + valor + ")");
           System.out.println(MensagemOperacao.SAQUE_TAXA_APLICADA.getMensagem() + " R$: " + TipoTaxaSaque.COMUM.getValor()); 
        }else {
            System.out.println(MensagemOperacao.VALOR_INVALIDO.getMensagem());
        }
        return saldo;
        
        
    }
    public void aplicar (double valor, ContaPoupanca contaPoupanca){ //transfere da conta corrente pra conta poupanca
        if (valor > 0 && valor <= this.saldo){ // verifica se o valor é maior que zero e se é menor ou igual ao saldo
            this.saldo -= valor;
            contaPoupanca.depositar(valor);
           
            System.out.println(MensagemOperacao.TRANSFERENCIA_SUCESSO.getMensagem() + "(" + valor + ")");
        }else {
            System.out.println(MensagemOperacao.VALOR_INVALIDO.getMensagem());
        }
        
        
    }
    
}
