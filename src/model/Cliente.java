
package model;



public class Cliente { 
    
    private String nome;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    
    public Cliente (String nome, ContaCorrente cc, ContaPoupanca cp){ // construtor que define o que o cliente deve ter para ser considerado como tal
        this.nome = nome;
        this.contaCorrente = cc;
        this.contaPoupanca = cp;
        
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    } 

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }
    
            
}
