package Exercicios_Condicionais;

import java.util.Scanner;
import java.util.function.Predicate;

/*2. Escreva um programa que tenha a funcionalidade de uma calculadora simples. O programa
deve solicitar a digita��o de dois operandos e um operador (+ - x * / %) e deve imprimir ao
resultado da opera��o aritm�tica. Caso o usu�rio digite um operador inv�lido, o programa
deve imprimir "Operador desconhecido".
*/

public class Operacao_Simples_Predicate {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		double operando1;
		do {
			System.out.print("Digite o primeiro operando: ");
			// Verifica se o proximo token de entrada e um double
			while (!scanner.hasNextDouble()) {
				System.out.println("Por favor, digite um n�mero v�lido.");
				scanner.next(); // Consumir o proximo token de entrada
			}
			operando1 = scanner.nextDouble();
		} while (operando1 == Double.MAX_VALUE);

		System.out.print("Digite o operador (+ - x * / %): ");
		String operador = scanner.next();

		double operando2;
		do {
			System.out.print("Digite o segundo operando: ");
			// Verifica se o proximo token de entrada e um double
			while (!scanner.hasNextDouble()) {
				System.out.println("Por favor, digite um n�mero v�lido.");
				scanner.next(); // Consumir o proximo token de entrada
			}
			operando2 = scanner.nextDouble();
		} while (operando2 == Double.MAX_VALUE);

		double resultado = 0;

		Predicate<String> operadorSoma = i -> i.equals("+");
		Predicate<String> operadorSubtracao = i -> i.equals("-");
		Predicate<String> operadorDivisao = i -> i.equals("/") || i.equals("%");
		Predicate<String> operadorMultiplicacao = i -> i.equals("*") || i.equals("x");

		if (operando1 > 0 && operando2 > 0) {
			calcularOperacao(operando1, operando2, operador, resultado, operadorSoma, operadorSubtracao,
					operadorDivisao, operadorMultiplicacao);
		} else if ((operando1 == 0 || operando2 == 0) && operador.equals("/") || operador.equals("%")) {
			System.out.println("N�o e permitido valores dos operandos com 'Zero' para esta opera��o.");
		} else if (operando1 < 0 || operando2 < 0) {
			System.out.println("N�o e permitido valores dos operandos invalidos.");
		} else {
			calcularOperacao(operando1, operando2, operador, resultado, operadorSoma, operadorSubtracao,
					operadorDivisao, operadorMultiplicacao);
		}
	}

	public static Double calcularOperacao(double operando1, double operando2, String operador, double resultado,
			Predicate<String> operadorSoma, Predicate<String> operadorSubtracao, Predicate<String> operadorDivisao,
			Predicate<String> operadorMultiplicacao) {

		if (operadorSoma.test(operador)) {
			resultado = operando1 + operando2;
		} else if (operadorSubtracao.test(operador)) {
			resultado = operando1 - operando2;
		} else if (operadorDivisao.test(operador)) {
			resultado = operando1 / operando2;
		} else if (operadorMultiplicacao.test(operador)) {
			resultado = operando1 * operando2;
		} else {
			operador = "Operador Desconhecido";
			System.out.println(operador);
			System.exit(0);
		}
		System.out.println("O valor da opera��o e: " + resultado);
		return resultado;
	}
}