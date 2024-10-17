package banco;

public class Main {
	
	// classe principal que testa o programa
    public static void main(String[] args) {
        //cria a conta corrente 
        ContaCorrente contaCorrente = new ContaCorrente(1000, 500);
        ContaPoupanca contaPoupanca = new ContaPoupanca(1000);

        //testa a conta corrente
        System.out.println("Saldo da Conta Corrente: " + contaCorrente.consulta());
        contaCorrente.deposito(200);
        contaCorrente.saque(1200); //deve ser permitido por que o saldo + limite = 1000 + 500
        System.out.println("Saldo da Conta Corrente após saque: " + contaCorrente.consulta());

        //testa o saldo 
        System.out.println("Saldo da Conta Poupança: " + contaPoupanca.consulta());
        contaPoupanca.deposito(200);
        contaPoupanca.saque(300);
        System.out.println("Saldo da Conta Poupança após saque: " + contaPoupanca.consulta());
    }
}
