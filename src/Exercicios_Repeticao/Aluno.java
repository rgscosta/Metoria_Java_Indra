package Exercicios_Repeticao;

import java.time.LocalDate;

public class Aluno {

	int matricula;
	static int nextmatricula = 1;
	String nomeAluno;
	int classe;
	String turma;
	double nota1;
	double nota2;
	double media;
	String situacao;
	LocalDate dataNascimento;


	public Aluno(String nomeAluno, double nota1, double nota2, LocalDate dataNascimento, int classe, String turma) {
		this.matricula = nextmatricula++;
		this.nomeAluno = nomeAluno;
		this.turma = turma;
		this.classe = classe;
		this.dataNascimento = dataNascimento;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = (nota1 + nota2) / 2.0;
		this.situacao = this.media >= 7 ? "Aprovado" : "Reprovado";
	}

	// Serve para imprimir o cadastro do aluno na tela
	@Override
	public String toString() {
		return "Matricula:" + matricula + "\n" + "Nome:" + nomeAluno + "\n" + "Classe:" + classe + "\n" + "Turma:" + turma +  "\n" + "Nota 1:" + nota1 + "\n" + "Nota 2:"
				+ nota2 + "\n" + "Média:" + media + "\n" + "Situação:" + situacao + "\n";
	}

}
