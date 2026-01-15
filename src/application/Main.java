package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o número da conta: ");
		int num = sc.nextInt();
		sc.nextLine();

		System.out.println("Nome do titular: ");
		String titular = sc.nextLine();

		System.out.println("Deseja fazer algum depósito [s/n] ? ");
		char resp = sc.next().charAt(0);

		double depositoInicial = 0;

		if (resp == 's') {
			System.out.println("Insira o valor para depósito: ");
			depositoInicial = sc.nextDouble();

		} else {
			depositoInicial = 0.0;
		}

		Conta conta1 = new Conta(num, titular, depositoInicial);

		System.out.println(conta1);
		int opc;
		do {
			System.out.println("---------------------------- ");
			System.out.println(" Selecione as opções abaixo:");
			System.out.println("      [1] Depositar          ");
			System.out.println("      [2] Sacar         ");
			System.out.println("      [3] Transferir         ");
			System.out.println("      [4] Sair          ");
			System.out.println("---------------------------- ");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				System.out.println("Insira o valor que deseja depositar: ");
				double valDep = sc.nextDouble();
				conta1.depositar(valDep);
				System.out.println(conta1);
				break;
			case 2:
				System.out.println("Insira o valor para saque: ");
				double valSaq = sc.nextDouble();

				boolean sucesso = conta1.sacar(valSaq);
				if (!sucesso) {
					System.out.println("Saldo insuficiente ou valor inválido.");
				}

				System.out.println(conta1);
				break;

			case 3:
				System.out.println("Valor para transferência: ");
				double valTraf = sc.nextDouble();
				boolean ok = conta1.transferir(valTraf);
				if (!ok) {
					System.out.println("Transferência inválida.");

				}
				System.out.println(conta1);
				break;

			case 4:
				System.out.println("Sistema finalizado");
			}

		} while (opc != 4);

		System.out.println(conta1);
	}

}
