
package model;


public interface Tarifavel { // obriga a conta corrente a ter os metodos abaixo
    
    public void aplicarTarifaMensal (double valor); 
    public void cobrarTaxa(double valor);
    
}
