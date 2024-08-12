package Exercicios_Repeticao;

import java.util.Random;
import java.util.Scanner;

public class ChuteCerto {

	public static void main(String[] args) {

		Random random = new Random();
		int numeroEscolhido = random.nextInt(100) + 1;
		try (Scanner scanner = new Scanner(System.in)) {
			int tentativas = 5;

			System.out.println("Chute o n�mero escolhido entre 1 e 100.");
			System.out.println("Voc� tem " + tentativas + " chances para acertar.");

			for (int i = 0; i < tentativas; i++) {
				System.out.print("Chute " + (i + 1) + ": ");
				int chute = scanner.nextInt();

				if (chute == numeroEscolhido) {
					System.out.println("Voc� acertou o n�mero " + numeroEscolhido + "!");
					return;
				} else {
					if ((chute >= numeroEscolhido - 5 && chute <= numeroEscolhido + 5)) {
						System.out.println("Quente!");
					} else {
						System.out.println("Frio!");
					}
				}
			}
		}
		System.out.println("Voc� usou todas seus chutes. O n�mero do chute Certo era " + numeroEscolhido + ".");
	}

}
