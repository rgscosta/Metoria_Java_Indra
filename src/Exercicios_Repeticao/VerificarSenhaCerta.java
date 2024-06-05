package Exercicios_Repeticao;

import java.util.Scanner;

public class VerificarSenhaCerta {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Senha correta definida como exemplo
		String senhaCorreta = "12345678";
		// QTD maximo de vezes para tentar
		int tentativasRestantes = 3;

		while (tentativasRestantes > 0) {
			System.out.println("Digite a senha de 8 caracteres: ");
			String senhaDigitada = scanner.nextLine();

			if (senhaDigitada.equals(senhaCorreta)) {
				System.out.println("Senha correta!");
				break;
			} else {
				System.out.println("Senha incorreta. Tente novamente.");
				tentativasRestantes--;
				if (tentativasRestantes > 0) {
					System.out.println("Tentativas restantes: " + tentativasRestantes);
				}
			}
		}

		if (tentativasRestantes == 0) {
			System.out.println("Você excedeu o número de tentativas. O programa será finalizado.");
		}
		scanner.close();
	}

}
