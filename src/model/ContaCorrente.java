
package model;


public class ContaCorrente extends Conta implements Tarifavel{ // ContaCorrente extends conta pq é subclasse de conta e implements Tarifavel pq é suscetivel às tarifas

    
    
    private static final double taxaSaque = 2.5;
    
    
    public ContaCorrente(String titular, double saldo, int numConta) {
        super (titular, saldo, numConta);
    }

    @Override
    public void aplicarTarifaMensal(double tarifa) { // metodo de tarifa mensal
        if (tarifa > 0){
            this.saldo -= tarifa;
            System.out.println("A tarifa mensal de: R$" + tarifa + " foi aplicada.");
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
        if (valor > 0 && valor + taxaSaque <= saldo){ // verifica se o valor é positivo e se é menor ou igual ao saldo
           saldo -= (valor + taxaSaque); 
           System.out.println("O saque de " + valor + "foi feita com sucesso");
           System.out.println("A taxa de saque de " + taxaSaque + "foi aplicada"); 
        }else {
            System.out.println("o valor inserido é inválido, tente novamente.");
        }
        return saldo;
        
        
    }
    public void aplicar (double valor, ContaPoupanca contaPoupanca){ //transfere da conta corrente pra conta poupanca
        if (valor > 0 && valor <= this.saldo){ // verifica se o valor é maior que zero e se é menor ou igual ao saldo
            this.saldo -= valor;
            contaPoupanca.depositar(valor);
           
            System.out.println("o valor de " + valor + "foi aplicado na conta poupanca");
        }else {
            System.out.println("o valor digitado é inválido, tente novamente");
        }
        
        
    }
    
}
