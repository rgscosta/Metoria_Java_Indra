package Exercicios_Repeticao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CadastroConsultaEscola {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Aluno> alunos = new ArrayList<>();
		boolean continuaCadastro = true;
		boolean continuaConsulta = true;
		boolean continuaNomes;
		boolean continuaPreenchimentos = true;
		boolean alunoEncontrado = false;
		int consultaMatricula;

		String nomeAluno = "";
		double nota1 = 0.0;
		double nota2 = 0.0;
		int classe;
		String turma = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Pattern datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
		String dataNascimentoStr = "";
		LocalDate dataNascimento;

		// Cadastro dos alunos
		while (continuaCadastro) {

			continuaNomes = true;

			while (continuaNomes) {
				System.out.print("Digite o nome do aluno (ou 'sair' para finalizar os cadastros): ");
				nomeAluno = scanner.nextLine();
				if (nomeAluno.matches("[A-Za-zÀ-ú ]+")) {
					if (nomeAluno.equalsIgnoreCase("sair")) {
						System.out.println("Finalizando os cadastros...\n");
						continuaCadastro = false;
						continuaPreenchimentos = false;
						break;
					}

					for (Aluno aluno : alunos) {
						if ((aluno.nomeAluno != null || aluno.nomeAluno != "") && aluno.nomeAluno.equals(nomeAluno)) {
							System.out.print("Aluno já esta matriculado.\n\n");
							continuaNomes = true;
						}
					}

				} else {
					System.out.println("Nome inválido. Por favor, digite um nome que contenha apenas letras.");
					continuaNomes = true;
				}
				continuaNomes = false;
			}
			if (continuaPreenchimentos) {

				while (true) {
					System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
					dataNascimentoStr = scanner.nextLine();
					if (datePattern.matcher(dataNascimentoStr).matches()) {
						try {
							dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
							if (dataNascimento.getYear() >= 1900) {
								break;
							} else {
								System.out.println("Ano inválido. Por favor, digite um ano a partir de 1900.");
							}
						} catch (DateTimeParseException e) {
							System.out.println("Data inválida. Por favor, digite no formato dd/MM/yyyy.");
						}
					} else {
						System.out.println("Data inválida. Por favor, digite no formato dd/MM/yyyy.");
					}
				}

				while (true) {
					System.out.print("Digite a classe do aluno (entre 1º ao 9º ano): ");
					classe = scanner.nextInt();
					if (classe >= 0 && classe < 9) {
						break;
					} else {
						System.out.println("Classe inválida. Por favor, digite uma classe entre 1º ao 9º ano.");
					}
				}
				// Consumir a nova linha pendente
				scanner.nextLine();

				while (true) {
					System.out.print("Digite a turma do aluno: ");
					turma = scanner.nextLine();
					if (turma.matches("[A-Za-zÀ-ú ]+")) {
						break;
					} else {
						System.out.println("Turma inválida. Por favor, digite uma turma usando apenas letras.");
					}
				}

				while (true) {
					System.out.print("Digite a primeira nota (entre 0 e 10): ");
					nota1 = scanner.nextDouble();
					if (nota1 >= 0 && nota1 <= 10) {
						break;
					} else {
						System.out.println("Nota inválida. Por favor, digite uma nota entre 0 e 10.");
					}
				}

				while (true) {
					System.out.print("Digite a segunda nota (entre 0 e 10): ");
					nota2 = scanner.nextDouble();
					if (nota2 >= 0 && nota2 <= 10) {
						break;
					} else {
						System.out.println("Nota inválida. Por favor, digite uma nota entre 0 e 10.");
					}
				}

				// Consumir a nova linha pendente
				scanner.nextLine();

				// Criar e adicionar o aluno a lista de ArrayList criado no inicio.
				Aluno aluno = new Aluno(nomeAluno, nota1, nota2, dataNascimento, classe, turma);
				alunos.add(aluno);

				System.out.println("Matricula: " + aluno.matricula + "\n");

				System.out.println("Aluno cadastrado com Sucesso.\n");
			}
		}

		// Consulta dos alunos
		while (continuaConsulta) {
			System.out.print("Digite o número da matricula do aluno para consultar (ou 0 para sair): ");
			consultaMatricula = scanner.nextInt();
			if (consultaMatricula != 0) {
				System.out.print("\n");
				System.out.print("-------------------Cadastro de Alunos-----------------\n\n");
			}
			if (consultaMatricula == 0) {
				System.out.println("\n");
				System.out.println("Finalizando a consulta...\n");
				break;
			}

			for (Aluno aluno : alunos) {
				if (aluno.matricula == consultaMatricula) {
					// Imprimindo o Aluno la no metodo de toString
					System.out.println(aluno);
					alunoEncontrado = true;
					break;
				}
			}
			if (!alunoEncontrado) {
				System.out.println("Matricula não localizada - nº: " + consultaMatricula + "\n");
			}
			System.out.print("------------------------------------------------------\n");
			System.out.print("\n");
			alunoEncontrado = false;
		}
		scanner.close();
	}

}
