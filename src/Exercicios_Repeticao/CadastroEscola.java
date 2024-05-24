package Exercicios_Repeticao;

import java.util.Scanner;

public class CadastroEscola {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String nomeAluno;
        double nota1;
        double nota2;
        double media;
        int matricula;
        boolean continua = true;
        
        // Loop para continuar a leitura atÃ© que o nÃºmero inserido seja zero
        while (continua) {
            System.out.println("Digite o número da matricula do aluno ou (0 para sair): ");
             matricula = scanner.nextInt();
            
            if(matricula == 0) {
                System.out.println("Digitou 0 para sair !!!");
            	break;
            }
            // Consumir a nova linha pendente
            scanner.nextLine();
            
            System.out.println("Digite o nome do aluno: ");
            nomeAluno = scanner.nextLine();
            
            System.out.println("Digite a primeira nota: ");
            nota1 = scanner.nextDouble();
            
            System.out.println("Digite a segunda nota: ");
            nota2 = scanner.nextDouble();
            
            media = (nota1 + nota2) / 2.0;
            String situacao = media >= 7 ? "Aprovado" : "Reprovado";
            
            System.out.println("MatrÃ­cula: " + matricula);
            System.out.println("Nome: " + nomeAluno);
            System.out.println("Média: " + media);
            System.out.println("Situação: " + situacao);
            System.out.println();
        }
        scanner.close();
    }
	
}
