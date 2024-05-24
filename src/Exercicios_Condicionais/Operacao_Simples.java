package Exercicios_Condicionais;

import java.util.Scanner;

/*2. Escreva um programa que tenha a funcionalidade de uma calculadora simples. O programa
deve solicitar a digitação de dois operandos e um operador (+ - x * / %) e deve imprimir ao
resultado da operação aritmética. Caso o usuário digite um operador inválido, o programa
deve imprimir "Operador desconhecido".
*/

public class Operacao_Simples {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		double operando1;
		do {
			System.out.print("Digite o primeiro operando: ");
			// Verifica se o token de entrada e um double
			while (!scanner.hasNextDouble()) {
				System.out.println("Por favor, digite um numero válido.");
				scanner.next(); // Consumir o  token de entrada
			}
			operando1 = scanner.nextDouble();
		} while (operando1 == Double.MAX_VALUE);

		System.out.print("Digite o operador (+ - x * / %): ");
		String operador = scanner.next();

		double operando2;
		do {
			System.out.print("Digite o segundo operando: ");
			// Verifica se o  token de entrada e um double
			while (!scanner.hasNextDouble()) {
				System.out.println("Por favor, digite um número válido.");
				scanner.next(); // Consumir o  token de entrada
			}
			operando2 = scanner.nextDouble();
		} while (operando2 == Double.MAX_VALUE);

		double resultado = 0;

		if (operando1 > 0 && operando2 > 0) {
			realizarOperacao(operando1, operando2, operador, resultado);
		} else if ((operando1 == 0 || operando2 == 0) && (operador.equals("/") || operador.equals("%"))) {
			System.out.println("Não é permitido valores dos operandos com 'Zero' para esta operação.");
		} else if (operando1 < 0 || operando2 < 0) {
			System.out.println("Não é permitido valores dos operandos invalidados.");
		} else {
			realizarOperacao(operando1, operando2, operador, resultado);
		}
	}

	public static void realizarOperacao(double operando1, double operando2, String operador, double resultado) {

		switch (operador) {
		case "+":
			resultado = operando1 + operando2;
			break;
		case "-":
			resultado = operando1 - operando2;
			break;
		case "x":
		case "*":
			resultado = operando1 * operando2;
			break;
		case "/":
			resultado = operando1 / operando2;
			break;
		case "%":
			resultado = operando1 % operando2;
			break;
		default:
			System.out.println("Operador desconhecido");
			return;
		}
		System.out.println("Resultado: " + resultado);
	}
}