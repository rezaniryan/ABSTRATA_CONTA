package banco;

// classe abstract que representa a conta bancaria
public abstract class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    // class abstract que realiza o saque
    public abstract void saque(double valor);
    // classe abstract que realiza o deposito
    public abstract void deposito(double valor);
    // metodo que verifica o saldo da conta
    public abstract double consulta();
}

// classe que representa a conta corrente
class ContaCorrente extends ContaBancaria {
    private double limite;

    //construtor que inicializa o saldo e o limite da conta corrente
    public ContaCorrente(double saldoInicial, double limite) {
        super(saldoInicial);
        this.limite = limite;
    }
    
    //realiza o saque considerando o saldo e o limite
    @Override
    public void saque(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor; // sem taxa por simplicidade
        } else {
            System.out.println("Saque não permitido. Saldo e limite insuficientes.");
        }
    }

    //metodo que realiza um deposito na conta corrente
    @Override
    public void deposito(double valor) {
        saldo += valor; // sem taxa por simplicidade
    }

    @Override
    public double consulta() {
        return saldo; // sem taxa por simplicidade
    }
}

// classe da conta poupanca
class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    // metodo que realiza um saque apenas se o saldo for suficiente
    @Override
    public void saque(double valor) {
    	//verifica se o valor a ser sacado e menor ou igual ao saldo
        if (valor <= saldo) {
            saldo -= valor; // sem taxa por simplicidade
        } else {
            System.out.println("Saque não permitido. Saldo insuficiente.");
        }
    }

    //metodo que realiza um deposito na conta poupança
    @Override
    public void deposito(double valor) {
        saldo += valor; // sem taxa por simplicidade
    }

    //metodo que retorna o saldo atual da conta poupança
    @Override
    public double consulta() {
        return saldo; // sem taxa por simplicidade
    }
}