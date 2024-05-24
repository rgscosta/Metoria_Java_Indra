package Exercicios_Condicionais;

import java.util.Scanner;

/*3. Escreva um programa que solicite a digitação de um caractere qualquer do teclado e
imprima sua classificação: vogal, consoante, número e caractere especial.*/


public class SelecaoTecla {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um caractere: ");
		char valorDigitado = scanner.next().charAt(0);

		// Validar se o que foi digitado e uma Letra
		if (Character.isLetter(valorDigitado)) {
			// Se for uma letra mais e uma vogal
			if (isVogal(valorDigitado)) {
				System.out.println("É uma vogal.");
				// Se nao foi uma vogal e uma letra sao pode ser consoante
			} else {
				System.out.println("É uma consoante.");
			}
			// Validar se o que foi digitado nao euma letra se foi um numero inteiro
		} else if (Character.isDigit(valorDigitado)) {
			System.out.println("É um número.");
			// Se nao foi um numero inteiro e por que e um caractere especial
		} else {
			System.out.println("É um caractere especial.");
		}

		scanner.close();
	}

	public static boolean isVogal(char c) {
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
