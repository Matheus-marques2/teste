
package model;

import java.util.Arrays;
import model.Enums.TipoConta;

public abstract class Conta {
     
    
    private String titular;
    protected double saldo; // protected para que a subclasse ContaCorrente possa ter acesso
    private int numConta;
    private TipoConta tipoConta;
    
    public Conta (String titular, double saldo, int numConta, TipoConta tipoConta){ // define oq é necessário para uma conta existir
        
        this.titular = titular;
        this.saldo = saldo;
        this.numConta = numConta;
        this.tipoConta = tipoConta;
    }
    
    // set = coloca o valor naquela variavel
    // get = pega o valor daquela variavel

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    
    public String exibirDados (){ // metodo para exibir os dados da conta
        return "titular: " + titular +
                "\nSaldo: " + saldo +
                "\nNúmero da conta: " + numConta +
                "\nTipo de conta: " + tipoConta;
        
    } 
    
    public double depositar (double valor){ // metodo de deposito
        return saldo += valor;
        
    }
    
    public double sacar (double valor) { // metodo de saque
        return saldo -= valor;
        
    }
    public void alterarSaldo (double valor){ // metodo public que altera o saldo private
        if (valor != 0){
            this.saldo += valor;
        }
    }
    
    
}
