
package model;


public class Enums {
    
  public enum TipoTaxaSaque {
      COMUM (2.5);
      
      private final double valor;
      
      TipoTaxaSaque(double valor) {
          this.valor = valor;
      }

        public double getValor() {
            return valor;
        }
      
  } 
  
  public enum TipoConta {
      CORRENTE,
      POUPANCA;
          
  }
  
  public enum MensagemOperacao {
    SAQUE_SUCESSO("Saque realizado com sucesso"),
    SAQUE_INSUFICIENTE("Saldo insuficiente para realizar o saque"),
    TARIFA_APLICADA("A tarifa foi aplicada com sucesso"),
    SAQUE_TAXA_APLICADA("A taxa de saque foi aplicada"),
    VALOR_INVALIDO("O valor inserido é inválido, tente novamente"),
    TRANSFERENCIA_SUCESSO("Transferência realizada com sucesso"),
    TRANSFERENCIA_INVALIDA("O valor de transferência é inválido"),
    RESGATE_SUCESSO ("O valor foi transferido com sucesso para conta corrente"),
    SALDO_INICIAL_INVALIDO("não é permitido começar uma conta com saldo negativo, o valor do saldo inicial será 0");

    private final String mensagem;

    MensagemOperacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
   
}
