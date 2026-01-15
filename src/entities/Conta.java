package entities;

public class Conta {
	private int numeroConta;
	private String titular;
	private double saldo;

	public Conta(int numeroConta, String titular, double depositoInicial) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = depositoInicial;
	}

	public Conta(int numeroConta, String titular) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = 0;

	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void depositar(double valorDeposito) {
		if (valorDeposito > 0) {
			saldo += valorDeposito;
		}
	}

	public boolean sacar(double valorDeSaque) {
		if (valorDeSaque > 0 && valorDeSaque + 5.0 <= saldo) {
			saldo -= valorDeSaque + 5.0; // taxa de 5 reais
			return true;
		}
		return false;
	}

	public boolean transferir(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Conta: " + numeroConta + ", Titular: " + (titular) + ", Saldo: " + saldo;

	}

}
