package Exercicios_Repeticao;

public class Aluno {

	int matricula;
	String nomeAluno;
	double nota1;
	double nota2;
	double media;
	String situacao;

	// Construtor de que o aluno recebe
	public Aluno(int matricula, String nomeAluno, double nota1, double nota2) {
		this.matricula = matricula;
		this.nomeAluno = nomeAluno;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = (nota1 + nota2) / 2.0;
		this.situacao = this.media >= 7 ? "Aprovado" : "Reprovado";
	}

	// Serve para imprimir o cadastro do aluno na tela
	@Override
	public String toString() {
		return "Matricula: " + matricula + "\n" + "Nome: " + nomeAluno + "\n" + "Nota 1: " + nota1 + "\n" + "Nota 2: "
				+ nota2 + "\n" + "Média: " + media + "\n" + "Situação: " + situacao;
	}

}
