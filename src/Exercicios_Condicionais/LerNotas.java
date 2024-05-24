package Exercicios_Condicionais;

import java.util.Scanner;

/*4. Escreva um programa que leia quatro notas e imprima a média obtida, desprezando a nota mais baixa
*/

public class LerNotas {
	

	static boolean isInvalido = false;
	static double soma = 0;
	static double menorNota = Double.POSITIVE_INFINITY;

	public static void main(String[] args) {
		//Chamar o calculo das notas para definir a média;
		solicitarNotas();

		if (!isInvalido) {
			// Calcula a média desprezando a menor nota.
			double media = (soma - menorNota) / 3;
			System.out.printf("Desprezando a nota mais baixa:" + menorNota +","+" A média das notas é:%.2f" , media);
		} else {
			System.out.println("Digite novamente as notas.");
		}
	}

	public static double solicitarNotas() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// Receber as quatro notas
		for (int i = 1; i <= 4; i++) {
			System.out.print("Digite a nota " + i + ": ");

			double nota = scanner.nextDouble();

			if (nota < 0) {
				System.out.println("Apenas notas positivas são permitidas.");
				isInvalido = true;
				break; // interrompe o loop se uma nota negativa for digitada
			}

			soma += nota;

			// Receber a menor nota
			if (nota < menorNota) {
				menorNota = nota;
			}
		}
		return menorNota;
	}

}
