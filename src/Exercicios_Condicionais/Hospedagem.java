package Exercicios_Condicionais;

import java.util.Scanner;
import java.util.function.Predicate;

/*5. Escreva um programa para calcular a conta final de um hospede de um hotel, considerando que:
a) Sera lidos o nome do hospede, o tipo do apartamento utilizado (A, B, C ou D), o N�mero de
di�rias utilizadas pelo hospede e o valor do consumo interno do hospede;
b) O valor da diaria determinado pela seguinte tabela:
	A = 150.00
	B = 100,00
	C = 75,00
	D = 50,00 
c) O valor total das di�rias calculado pela multiplicacao do N�mero de di�rias utilizadas pelo
valor da diaria;
d) O subtotal  calculado pela soma do valor total das di�rias e o valor do consumo interno;
e) O valor da taxa de servi�o equivale a 10% do subtotal;
f) O total geral resulta da soma do subtotal com a taxa de servi�o.
O programa dever mostrar a conta final do hospede, contendo: o nome do hospede, o tipo do
apartamento, o N�mero de di�rias utilizadas, o valor unitrio da diaria, o valor total das di�rias, o
valor do consumo interno, o subtotal, o valor da taxa de servi�o e o total geral.*/

public class Hospedagem {

	public static void main(String[] args) {

		double taxaServico;
		double descontoTaxaServico = 0.0;

		Scanner scanner = new Scanner(System.in);

		// Leitura e validacao dos dados do hospede
		String nomeHospede;
		do {
			System.out.print("Nome do hospede (apenas letras): ");
			nomeHospede = scanner.nextLine();
			if (!nomeHospede.matches("[a-zA-Z]+")) {
				System.out.println("Nome invalido. Digite apenas letras.");
			}
		} while (!nomeHospede.matches("[a-zA-Z]+"));

		// Leitura e validacao do tipo do apartamento
		char tipoApartamento;
		do {
			System.out.print("Tipo do apartamento (A, B, C ou D): ");
			tipoApartamento = scanner.next().charAt(0);
			if (tipoApartamento != 'A' && tipoApartamento != 'B' && tipoApartamento != 'C' && tipoApartamento != 'D') {
				System.out.println("Tipo de apartamento invalido. Digite novamente.");
			}
		} while (tipoApartamento != 'A' && tipoApartamento != 'B' && tipoApartamento != 'C' && tipoApartamento != 'D');

		// Leitura e validacao do N�mero de di�rias
		int numDiarias;
		do {
			System.out.print("N�mero de di�rias utilizadas: ");
			numDiarias = scanner.nextInt();
			if (numDiarias <= 0) {
				System.out.println("O N�mero de di�rias deve ser positivo. Digite novamente.");
			}
		} while (numDiarias <= 0);

		// Leitura e validacao do Consumo Interno
		double consumoInterno;
		do {
			System.out.print("Valor do consumo interno (use virgula para decimal): ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Entrada invalida. Digite apenas N�meros com virgula para decimal.");
				scanner.next();
			}
			consumoInterno = scanner.nextDouble();
			if (consumoInterno < 0) {
				System.out.println("O valor do consumo interno deve ser valores positivo. Digite novamente.");
			}
		} while (consumoInterno < 0);

		// Chamar o metodo para classificar o Tipo do apartamento e obter o valor da diaria
		double valorDiaria = classificarApartamento(tipoApartamento);

		// Calculo do valor total das di�rias
		double valorTotalDiarias = numDiarias * valorDiaria;

		// Calculo do subtotal
		double subtotal = valorTotalDiarias + consumoInterno;

		// Calculo da taxa de servi�o de 10%
		if (consumoInterno == 0) {
			taxaServico = 0.0;
		} else {
			taxaServico = subtotal * 0.10;
		}
		// Calculo do total geral
		double totalGeral = subtotal + taxaServico;

		// Exibir a conta final
		System.out.println("\nDespesas do hospede: " + nomeHospede);
		System.out.println("Tipo do apartamento: " + tipoApartamento);
		System.out.println("N�mero de di�rias utilizadas: " + numDiarias + " di�rias");
		System.out.println("Valor unitario da di�ria: " + valorDiaria);
		System.out.println("Valor total das di�rias: " + valorTotalDiarias);
		System.out.println("Valor do consumo interno: " + consumoInterno);
		System.out.println("Subtotal: " + subtotal);
		if (consumoInterno == 0) {
			System.out.println("Valor da taxa de servi�o com desconto: " + descontoTaxaServico);
		} else {
			System.out.println("Valor da taxa de servi�o: " + taxaServico);
		}

		System.out.println("Total da hospedagem: " + totalGeral);
		// Fechar Scanner
		scanner.close();
	}

	public static double classificarApartamento(char tipoApartamento) {
		Predicate<Character> apartamentoA = q -> q == 'A';
		Predicate<Character> apartamentoB = q -> q == 'B';
		Predicate<Character> apartamentoC = q -> q == 'C';
		Predicate<Character> apartamentoD = q -> q == 'D';

		if (apartamentoA.test(tipoApartamento)) {
			return 150.0;
		} else if (apartamentoB.test(tipoApartamento)) {
			return 100.0;
		} else if (apartamentoC.test(tipoApartamento)) {
			return 75.0;
		} else if (apartamentoD.test(tipoApartamento)) {
			return 50.0;
		} else {
			System.out.println("Tipo de apartamento invalido.");
			return 0.0;
		}
	}

}
