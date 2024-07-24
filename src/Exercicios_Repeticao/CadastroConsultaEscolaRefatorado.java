package Exercicios_Repeticao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CadastroConsultaEscolaRefatorado {

	static Scanner scanner = new Scanner(System.in);
	static List<Aluno> alunos = new ArrayList<>();

	public static void main(String[] args) {

		int opcao;

		while (true) {
			System.out.print("************************** Cadastro de Alunos *****************************\n\n");
			System.out.println(
					"- Digite (1) para cadastro de Aluno \n- Digite (2) para consulta de Aluno \n- Digite (3) para alterar cadastro de Aluno \n- Digite (4) para excluir cadastro de Aluno \n- Digite (0) para sair ");
			System.out.print("=> ");
			try {
				opcao = scanner.nextInt();
				System.out.print("\n");
				scanner.nextLine(); // Consumir a nova linha

				switch (opcao) {
				case 1:
					cadastro();
					break;
				case 2:
					consulta();
					break;
				case 3:
					alterar();
					break;
				case 4:
					excluir();
					break;
				case 0:
					System.out.println("Finalizado cadastro!");
					scanner.close();
					return;
				default:
					System.out.println("Opção inválida. Por favor, digite uma opção válida.");
				}
			} catch (Exception e) {
				System.out.println("Entrada inválida. Por favor, digite um número.");
				scanner.nextLine(); // Consumir a entrada inválida
			}
		}
	}

	public static void cadastro() {

		String nomeAluno;
		LocalDate dataNascimento;

		while (true) {
			// Cadastrar o Nome do Aluno Novo;
			nomeAluno = cadastrarNomeAluno();
			// Cadastrar a Data de Nascimento do Aluno Novo;
			dataNascimento = cadastrarDataNascimento();

			// Verificar duplicidade de aluno com base no nome e data de nascimento
			if (verificarAlunoCadastrado(nomeAluno, dataNascimento)) {
				System.out.println("Aluno já cadastrado com o mesmo nome e data de nascimento. Tente novamente.\n");
			} else {
				break;
			}
		}
		// Cadastrar as Notas
		double nota1 = cadastrarNota("Digite a nota 1 (entre 0 e 10): ");
		double nota2 = cadastrarNota("Digite a nota 2 (entre 0 e 10): ");
		// Cadastrar a Classe
		Integer classe = cadastrarClasse();
		// Cadastrar a Turma
		String turma = cadastrarTurma();
		// Construtor com recebendo os dados
		Aluno aluno = new Aluno(nomeAluno, dataNascimento, nota1, nota2, classe, turma);
		// Calculando a Média
		aluno.calcularMedia();
		// Informando a Situação
		aluno.determinarSituacao();
		alunos.add(aluno);

		System.out.println("Matricula: " + aluno.matricula + "\n");
		System.out.println("Aluno cadastrado com Sucesso.\n");
	}

	private static String cadastrarNomeAluno() {
	    while (true) {
	        System.out.println("Digite o nome do aluno: ");
	        String nomeAluno = scanner.nextLine();

	        try {
	            if (nomeAluno.matches("[A-Za-zÀ-ú ]+")) {
	                return nomeAluno;
	            } else {
	                throw new NomeInvalidoException("\nNome inválido. Por favor, digite um nome que contenha apenas letras. \n");
	            }
	        } catch (NomeInvalidoException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}

	private static boolean verificarAlunoCadastrado(String nomeAluno, LocalDate dataNascimento) {
		for (Aluno aluno : alunos) {
			if (aluno.nomeAluno.equals(nomeAluno) && aluno.dataNascimento.equals(dataNascimento)) {
				return true;
			}
		}
		return false;
	}

	private static LocalDate cadastrarDataNascimento() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Pattern datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");

		while (true) {
			System.out.print("Digite a data de nascimento (dd/MM/yyyy): ");
			String dataNascimentoStr = scanner.nextLine();
			if (datePattern.matcher(dataNascimentoStr).matches()) {
				try {
					LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
					if (dataNascimento.getYear() >= 1900) {
						return dataNascimento;
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
	}

	private static double cadastrarNota(String pergunta) {
		while (true) {
			System.out.print(pergunta);
			String notaDigitada = scanner.nextLine();
			try {
				double nota = Double.parseDouble(notaDigitada);
				if (nota >= 0 && nota <= 10) {
					return nota;
				} else {
					System.out.println("Nota inválida. Por favor, digite uma nota entre 0 e 10.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, digite um número.");
			}
		}
	}

	private static int cadastrarClasse() {
		while (true) {
			System.out.print("Digite a classe do aluno (entre 1º ao 9º ano): ");
			String entrada = scanner.nextLine();

			try {
				// Remover o símbolo de grau, se presente
				String classeStr = entrada.replace("º", "").trim();
				int classe = Integer.parseInt(classeStr);

				if (classe >= 1 && classe <= 9) {
					return classe;
				} else {
					System.out.println("Classe inválida. Por favor, digite uma classe entre 1 e 9.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, digite um número válido.");
			}
		}
	}

	private static String cadastrarTurma() {
		while (true) {
			System.out.print("Digite a turma do aluno: ");
			String turma = scanner.nextLine();
			if (turma.matches("[A-Za-zÀ-ú ]+")) {
				return turma;
			} else {
				System.out.println("Turma inválida. Por favor, digite uma turma usando apenas letras.");
			}
		}
	}

	public static void consulta() {
		while (true) {
			System.out.print(
					"************************** Consulta de Alunos Cadastrados *****************************\n\n");
			System.out.println("Digite (1) para consultar por matrícula");
			System.out.println("Digite (2) para consultar por nome");
			System.out.println("Digite (3) para exportar todos os alunos para um arquivo");
			System.out.println("Digite (0) para finalizar consulta");
			System.out.print("=> ");
			int consultaOpcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			switch (consultaOpcao) {
			case 1:
				consultarPorMatricula();
				break;
			case 2:
				consultarPorNome();
				break;
			case 3:
				exportarAlunosParaArquivo();
				break;
			case 0:
				System.out.println("\nFinalizando a consulta...\n");
				return;
			default:
				System.out.println("Opção inválida. Por favor, tente novamente.");
			}
		}
	}

	private static void consultarPorMatricula() {
		System.out.print("Digite o número da matrícula do aluno para consultar: ");
		Integer consultaMatricula = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha

		boolean alunoEncontrado = false;
		for (Aluno aluno : alunos) {
			if (aluno.matricula.equals(consultaMatricula)) {
				System.out.println("************* Aluno Cadastrado *****************\n");
				System.out.println(aluno);
				alunoEncontrado = true;
				break;
			}
		}

		if (!alunoEncontrado) {
			System.out.println("Matrícula não localizada - nº: " + consultaMatricula + "\n");
		}
	}

	private static void consultarPorNome() {
		System.out.print("Digite o nome do aluno para consultar: ");
		String consultaNome = scanner.nextLine();

		boolean alunoEncontrado = false;
		for (Aluno aluno : alunos) {
			if (aluno.nomeAluno.equalsIgnoreCase(consultaNome)) {
				System.out.println("************* Aluno Cadastrado *****************\n");
				System.out.println(aluno);
				alunoEncontrado = true;
			}
		}

		if (!alunoEncontrado) {
			System.out.println("Nenhum aluno encontrado com o nome: " + consultaNome + "\n");
		}
	}

	private static void exportarAlunosParaArquivo() {
		String userHome = System.getProperty("user.home");
		String pastaCadastro = "Cadastro de Alunos";
		String caminhoDiretorio = userHome + File.separator + "Desktop" + File.separator + pastaCadastro;

		// Criar a pasta se não existir
		File pasta = new File(caminhoDiretorio);
		if (!pasta.exists()) {
			if (pasta.mkdirs()) {
				System.out.println("Pasta 'Cadastro de Alunos' criada com sucesso.");
			} else {
				System.out.println("Não foi possível criar a pasta 'Cadastro de Alunos'.");
				return;
			}
		}

		String caminhoArquivo = caminhoDiretorio + File.separator + "alunos_cadastrados.txt";

		try (PrintWriter writer = new PrintWriter(new File(caminhoArquivo))) {
			for (Aluno aluno : alunos) {
				writer.println(aluno);
			}
			System.out.println("Alunos exportados com sucesso para o arquivo '" + caminhoArquivo + "'.\n");
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao exportar alunos: " + e.getMessage());
		}
	}

	private static void alterar() {
		while (true) {
			System.out.print("************************** Alteração de Cadastrados *****************************\n\n");
			System.out.print("Digite o número da matricula do Aluno (ou 0 para sair): ");
			Integer consultaMatricula = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			if (consultaMatricula == 0) {
				break;
			}

			Aluno alunoEncontrado = null;
			for (Aluno aluno : alunos) {
				if (aluno.matricula.equals(consultaMatricula)) {
					alunoEncontrado = aluno;
					break;
				}
			}

			if (alunoEncontrado == null) {
				System.out.println("Matricula não localizada - nº: " + consultaMatricula + "\n");
				continue;
			}

			System.out.println("************* Cadastro localizado *****************\n");
			System.out.println(alunoEncontrado);

			System.out.println("Selecione qual opção deseja altera no cadastro do aluno:");
			System.out.println("Digite (1) - Nome do Aluno");
			System.out.println("Digite (2) - Data de Nascimento");
			System.out.println("Digite (3) - Nota 1");
			System.out.println("Digite (4) - Nota 2");
			System.out.println("Digite (5) - Classe");
			System.out.println("Digite (6) - Turma");
			System.out.println("Digite (0) - Cancelar");
			System.out.print("Digite uma opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			switch (opcao) {
			case 1:
				alunoEncontrado.nomeAluno = cadastrarNomeAluno();
				System.out.println("Nome do aluno: " + alunoEncontrado.nomeAluno + " alterado com sucesso! \n");
				break;
			case 2:
				alunoEncontrado.dataNascimento = cadastrarDataNascimento();
				System.out.println(
						"Data de nascimento do aluno: " + alunoEncontrado.nomeAluno + " alterado com sucesso! \n");
				break;
			case 3:
				alunoEncontrado.nota1 = cadastrarNota("Digite a nova nota 1 (entre 0 e 10): ");
				System.out.println("Nota 1 do aluno: " + alunoEncontrado.nomeAluno + " alterado com sucesso! \n");
				break;
			case 4:
				alunoEncontrado.nota2 = cadastrarNota("Digite a nova nota 2 (entre 0 e 10): ");
				System.out.println("Nota 2 do aluno: " + alunoEncontrado.nomeAluno + " alterado com sucesso! \n");
				break;
			case 5:
				alunoEncontrado.classe = cadastrarClasse();
				System.out.println("Classe do aluno: " + alunoEncontrado.nomeAluno + " alterado com sucesso! \n");
				break;
			case 6:
				alunoEncontrado.turma = cadastrarTurma();
				System.out.println("Turma do aluno: " + alunoEncontrado.nomeAluno + " alterado com sucesso! \n");

				break;
			case 0:
				System.out.println("Alteração cancelada.");
				return;
			default:
				System.out.println("Opção inválida.");
				continue;
			}

			// Recalcular média e situação após alteração das notas
			alunoEncontrado.calcularMedia();
			alunoEncontrado.determinarSituacao();
			break;
		}
	}

	private static void excluir() {

		while (true) {
			System.out.print(
					"************************** Exclução de Alunos Cadastrados *****************************\n\n");
			System.out.print("Digite o número da matricula do Aluno (ou 0 para sair): ");
			Integer consultaMatricula = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			if (consultaMatricula == 0) {
				break;
			}

			boolean alunoEncontrado = false;
			for (Aluno aluno : alunos) {
				if (aluno.matricula == consultaMatricula) {
					System.out.println("************* Aluno Cadastrado *****************\n");
					System.out.println(aluno);
					alunoEncontrado = true;
					alunos.remove(aluno);
					System.out.println("Aluno: " + aluno.nomeAluno + " da matricula nº: " + aluno.matricula
							+ "  - foi removido da base com sucesso! \n");
					break;
				}
			}

			if (!alunoEncontrado) {
				System.out.println("Matricula não localizada - nº: " + consultaMatricula + "\n");
			}
		}
	}
}
