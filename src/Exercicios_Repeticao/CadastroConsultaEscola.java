package Exercicios_Repeticao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroConsultaEscola {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Aluno> alunos = new ArrayList<>();
		boolean continua = true;
		boolean encontrado = false;

		// Cadastro dos alunos
		while (continua) {
			System.out.print(
					"Digite o número da matricula do aluno para realizar o cadastro ou (0 para finalizar os cadastros): ");
			int matricula = scanner.nextInt();
			if (matricula == 0) {
				System.out.println("Digitou 0 os cadastros foram finalizados !!!");
				break;
			}

			// Consumir a nova linha pendente
			scanner.nextLine();

			System.out.print("Digite o nome do aluno: ");
			String nomeAluno = scanner.nextLine();

			System.out.print("Digite a primeira nota: ");
			double nota1 = scanner.nextDouble();

			System.out.print("Digite a segunda nota: ");
			double nota2 = scanner.nextDouble();

			// Criar e adicionar o aluno Ã  lista de ArrayList criado no inicio.
			Aluno aluno = new Aluno(matricula, nomeAluno, nota1, nota2);
			alunos.add(aluno);

			System.out.println("Aluno cadastrado com sucesso!\n");
		}

		// Consulta dos alunos
		while (continua) {
			System.out.print("Digite o número da matricula do aluno para consultar (ou 0 para sair): ");
			int consultaMatricula = scanner.nextInt();
			if (consultaMatricula == 0) {
				System.out.println("Saindo da consulta...");
				break;
			}

			for (Aluno aluno : alunos) {
				if (aluno.matricula == consultaMatricula) {
					// Imprimindo o Aluno la no metodo de toString
					System.out.println(aluno);
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				System.out.println("Aluno com matricula " + consultaMatricula + " não encontrado.\n");
			}
		}
		scanner.close();
	}
	
}
