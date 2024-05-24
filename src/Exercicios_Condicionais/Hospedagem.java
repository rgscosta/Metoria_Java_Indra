package Exercicios_Condicionais;

import java.util.Scanner;
import java.util.function.Predicate;

/*5. Escreva um programa para calcular a conta final de um hóspede de um hotel, considerando que:
a) Serão lidos o nome do hóspede, o tipo do apartamento utilizado (A, B, C ou D), o número de
diárias utilizadas pelo hóspede e o valor do consumo interno do hóspede;
b) O valor da diária é determinado pela seguinte tabela:
	A = 150.00
	B = 100,00
	C = 75,00
	D = 50,00 
c) O valor total das diárias é calculado pela multiplicação do número de diárias utilizadas pelo
valor da diária;
d) O subtotal é calculado pela soma do valor total das diárias e o valor do consumo interno;
e) O valor da taxa de serviço equivale a 10% do subtotal;
f) O total geral resulta da soma do subtotal com a taxa de serviço.
O programa deverá mostrar a conta final do hóspede, contendo: o nome do hóspede, o tipo do
apartamento, o número de diárias utilizadas, o valor unitário da diária, o valor total das diárias, o
valor do consumo interno, o subtotal, o valor da taxa de serviço e o total geral.*/


public class Hospedagem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Leitura e validaÃ§Ã£o dos dados do hÃ³spede
		String nomeHospede;
		do {
			System.out.print("Nome do hospede (apenas letras): ");
			nomeHospede = scanner.nextLine();
			if (!nomeHospede.matches("[a-zA-Z]+")) {
				System.out.println("Nome invalido. Digite apenas letras.");
			}
		} while (!nomeHospede.matches("[a-zA-Z]+"));

		// Leitura e validaÃ§Ã£o do tipo do apartamento
		char tipoApartamento;
		do {
			System.out.print("Tipo do apartamento (A, B, C ou D): ");
			tipoApartamento = scanner.next().charAt(0);
			if (tipoApartamento != 'A' && tipoApartamento != 'B' && tipoApartamento != 'C' && tipoApartamento != 'D') {
				System.out.println("Tipo de apartamento invalido. Digite novamente.");
			}
		} while (tipoApartamento != 'A' && tipoApartamento != 'B' && tipoApartamento != 'C' && tipoApartamento != 'D');

		// Leitura e validaÃ§Ã£o do nÃºmero de diÃ¡rias
		int numDiarias;
		do {
			System.out.print("Número de diárias utilizadas: ");
			numDiarias = scanner.nextInt();
			if (numDiarias <= 0) {
				System.out.println("O número de diárias deve ser positivo. Digite novamente.");
			}
		} while (numDiarias <= 0);

		// Leitura e validaÃ§Ã£o do Consumo Interno
		double consumoInterno;
		do {
			System.out.print("Valor do consumo interno (use virgula para decimal): ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Entrada invalida. Digite apenas números com virgula para decimal.");
				scanner.next();
			}
			consumoInterno = scanner.nextDouble();
			if (consumoInterno <= 0) {
				System.out.println("O valor do consumo interno deve ser positivo. Digite novamente.");
			}
		} while (consumoInterno <= 0);

		// Chamar o mÃ©todo para classificar o Tipo do apartamento e obter o valor da
		// diÃ¡ria
		double valorDiaria = classificarApartamento(tipoApartamento);

		// CÃ¡lculo do valor total das diÃ¡rias
		double valorTotalDiarias = numDiarias * valorDiaria;

		// CÃ¡lculo do subtotal
		double subtotal = valorTotalDiarias + consumoInterno;

		// CÃ¡lculo da taxa de serviÃ§o de 10%
		double taxaServico = subtotal * 0.10;

		// CÃ¡lculo do total geral
		double totalGeral = subtotal + taxaServico;

		// ExibiÃ§Ã£o da conta final
		System.out.println("\nDespesas do hospede: " + nomeHospede);
		System.out.println("Tipo do apartamento: " + tipoApartamento);
		System.out.println("Número de diárias utilizadas: " + numDiarias + " diárias");
		System.out.println("Valor unitario da diária: " + valorDiaria);
		System.out.println("Valor total das diárias: " + valorTotalDiarias);
		System.out.println("Valor do consumo interno: " + consumoInterno);
		System.out.println("Subtotal: " + subtotal);
		System.out.println("Valor da taxa de serviço: " + taxaServico + " - 10% do valor total");
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
