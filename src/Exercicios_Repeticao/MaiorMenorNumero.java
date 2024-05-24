package Exercicios_Repeticao;

import java.util.Scanner;

public class MaiorMenorNumero {

	 public static void main(String[] args) {
	        
	    	Scanner scanner = new Scanner(System.in);

	        int maior = 0;
	        int menor = 0;
	        boolean primeiroNumero = true;

	        // Loop para continuar a leitura
	        while (true) {
	            System.out.println("Digite um número (0 para sair): ");
	            int numero = scanner.nextInt();

	            // Verifica se o numero digitado e zero para encerrar o programa
	            if (numero == 0) {
	                break;
	            }

	            // Se for a primeira vez o numero inserido, vai definir ele como o maior e o menor
	            if (primeiroNumero) {
	                maior = numero;
	                menor = numero;
	                primeiroNumero = false;
	            } else {
	                // Atualiza o maior e o menor numero.
	                if (numero > maior) {
	                    maior = numero;
	                }
	                if (numero < menor) {
	                    menor = numero;
	                }
	            }
	        }

	        // Exibe o maior e o menor numero, se houver mais de um numero inserido
	        if (!primeiroNumero) {
	            System.out.println("O maior número: " + maior);
	            System.out.println("O menor número: " + menor);
	        } else {
	            System.out.println("Nenhum número foi inserido.");
	        }

	        scanner.close();
	    }
	
	
}
