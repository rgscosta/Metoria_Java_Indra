package Exercicios_Repeticao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PesquisaEmissora {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Emissora> emissoras = new ArrayList<>();
		boolean continuaExterno = true;
		boolean continuaInterno = true;
		int total5 = 0, total7 = 0, total10 = 0, total12 = 0;
		double totalPessoas = 0;

		while (continuaExterno) {
			int numeroEmissora = -1;

			while (continuaInterno) {
				System.out.print("Qual é o número do canal 5, 7, 10 ou 12 (0 para sair): ");
				numeroEmissora = scanner.nextInt();

				if (numeroEmissora == 0) {
					continuaExterno = false;
					break;
				} else if (numeroEmissora == 5 || numeroEmissora == 7 || numeroEmissora == 10 || numeroEmissora == 12) {
					break;
				} else {
					System.out.println("O canal não existe. Por favor, digite um canal válido.");
				}
			}

			if (!continuaExterno) {
				break;
			}

			System.out.print("Digite a quantidade de pessoas assistindo o canal: ");
			int qtdAssistindo = scanner.nextInt();

			Emissora emissora = new Emissora(numeroEmissora, qtdAssistindo);
			emissoras.add(emissora);
		}

		// Calculando a quantidade total de pessoas assistindo cada canal
		for (Emissora emissora : emissoras) {
			int numero = emissora.getNumeroEmissora();
			int quantidade = emissora.getQtdAssistindo();

			switch (numero) {
			case 5:
				total5 += quantidade;
				break;
			case 7:
				total7 += quantidade;
				break;
			case 10:
				total10 += quantidade;
				break;
			case 12:
				total12 += quantidade;
				break;
			}

			totalPessoas += quantidade;
		}

		// Exibindo as porcentagens
		System.out.println("\nPorcentagem de pessoas assistindo cada canal:");
		if (totalPessoas > 0) {
			System.out.printf("Canal 5: %.2f%%\n", total5 / totalPessoas * 100);
			System.out.printf("Canal 7: %.2f%%\n", total7 / totalPessoas * 100);
			System.out.printf("Canal 10: %.2f%%\n", total10 / totalPessoas * 100);
			System.out.printf("Canal 12: %.2f%%\n", total12 / totalPessoas * 100);
		} else {
			System.out.println("Nenhuma pessoa assistindo os canais.");
		}

		scanner.close();
	}
}
