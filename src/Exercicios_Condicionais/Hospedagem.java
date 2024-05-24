package Exercicios_Condicionais;

import java.util.Scanner;
import java.util.function.Predicate;

/*5. Escreva um programa para calcular a conta final de um h�spede de um hotel, considerando que:
a) Ser�o lidos o nome do h�spede, o tipo do apartamento utilizado (A, B, C ou D), o n�mero de
di�rias utilizadas pelo h�spede e o valor do consumo interno do h�spede;
b) O valor da di�ria � determinado pela seguinte tabela:
	A = 150.00
	B = 100,00
	C = 75,00
	D = 50,00 
c) O valor total das di�rias � calculado pela multiplica��o do n�mero de di�rias utilizadas pelo
valor da di�ria;
d) O subtotal � calculado pela soma do valor total das di�rias e o valor do consumo interno;
e) O valor da taxa de servi�o equivale a 10% do subtotal;
f) O total geral resulta da soma do subtotal com a taxa de servi�o.
O programa dever� mostrar a conta final do h�spede, contendo: o nome do h�spede, o tipo do
apartamento, o n�mero de di�rias utilizadas, o valor unit�rio da di�ria, o valor total das di�rias, o
valor do consumo interno, o subtotal, o valor da taxa de servi�o e o total geral.*/


public class Hospedagem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Leitura e validação dos dados do hóspede
		String nomeHospede;
		do {
			System.out.print("Nome do hospede (apenas letras): ");
			nomeHospede = scanner.nextLine();
			if (!nomeHospede.matches("[a-zA-Z]+")) {
				System.out.println("Nome invalido. Digite apenas letras.");
			}
		} while (!nomeHospede.matches("[a-zA-Z]+"));

		// Leitura e validação do tipo do apartamento
		char tipoApartamento;
		do {
			System.out.print("Tipo do apartamento (A, B, C ou D): ");
			tipoApartamento = scanner.next().charAt(0);
			if (tipoApartamento != 'A' && tipoApartamento != 'B' && tipoApartamento != 'C' && tipoApartamento != 'D') {
				System.out.println("Tipo de apartamento invalido. Digite novamente.");
			}
		} while (tipoApartamento != 'A' && tipoApartamento != 'B' && tipoApartamento != 'C' && tipoApartamento != 'D');

		// Leitura e validação do número de diárias
		int numDiarias;
		do {
			System.out.print("N�mero de di�rias utilizadas: ");
			numDiarias = scanner.nextInt();
			if (numDiarias <= 0) {
				System.out.println("O n�mero de di�rias deve ser positivo. Digite novamente.");
			}
		} while (numDiarias <= 0);

		// Leitura e validação do Consumo Interno
		double consumoInterno;
		do {
			System.out.print("Valor do consumo interno (use virgula para decimal): ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Entrada invalida. Digite apenas n�meros com virgula para decimal.");
				scanner.next();
			}
			consumoInterno = scanner.nextDouble();
			if (consumoInterno <= 0) {
				System.out.println("O valor do consumo interno deve ser positivo. Digite novamente.");
			}
		} while (consumoInterno <= 0);

		// Chamar o método para classificar o Tipo do apartamento e obter o valor da
		// diária
		double valorDiaria = classificarApartamento(tipoApartamento);

		// Cálculo do valor total das diárias
		double valorTotalDiarias = numDiarias * valorDiaria;

		// Cálculo do subtotal
		double subtotal = valorTotalDiarias + consumoInterno;

		// Cálculo da taxa de serviço de 10%
		double taxaServico = subtotal * 0.10;

		// Cálculo do total geral
		double totalGeral = subtotal + taxaServico;

		// Exibição da conta final
		System.out.println("\nDespesas do hospede: " + nomeHospede);
		System.out.println("Tipo do apartamento: " + tipoApartamento);
		System.out.println("N�mero de di�rias utilizadas: " + numDiarias + " di�rias");
		System.out.println("Valor unitario da di�ria: " + valorDiaria);
		System.out.println("Valor total das di�rias: " + valorTotalDiarias);
		System.out.println("Valor do consumo interno: " + consumoInterno);
		System.out.println("Subtotal: " + subtotal);
		System.out.println("Valor da taxa de servi�o: " + taxaServico + " - 10% do valor total");
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
