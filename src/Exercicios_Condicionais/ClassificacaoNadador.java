package Exercicios_Condicionais;

import java.util.function.Predicate;

/*
1. Escreva um programa que verifique a idade de um nadador e classifique-o em uma das
seguintes categorias:
a) infantil A = 5 a 7 anos
b) infantil B = 8 a 10 anos
c) juvenil A = 11 a 13 anos
d) juvenil B = 14 a 17 anos
e) adulto = maiores de 18 anos
O nadador 1 tem 15 anos, o nadador 2 tem 23 e o nadador 3 tem 6 anos.*/

public class ClassificacaoNadador {
	
	public static void main(String[] args) {

		Integer nadadorIdade1 = 15;
		Integer nadadorIdade2 = 23;
		Integer nadadorIdade3 = 6;

		classificarNadador(nadadorIdade1);
		classificarNadador(nadadorIdade2);
		classificarNadador(nadadorIdade3);

	}

	public static void classificarNadador(int idade) {

		String categoriaNadador;

		Predicate<Integer> infantilA = i -> i >= 5 && i <= 7;
		Predicate<Integer> infantilB = i -> i >= 8 && i <= 10;
		Predicate<Integer> juvenilA = i -> i >= 11 && i <= 13;
		Predicate<Integer> juvenilB = i -> i >= 14 && i <= 17;

		if (infantilA.test(idade)) {
			categoriaNadador = "Infantil A";
		} else if (infantilB.test(idade)) {
			categoriaNadador = "Infantil B";
		} else if (juvenilA.test(idade)) {
			categoriaNadador = "Juvenil A";
		} else if (juvenilB.test(idade)) {
			categoriaNadador = "Juvenil B";
		} else {
			categoriaNadador = "Adulto";
		}
		System.out.println("O nadador com idade " + idade + " anos pertence a  categoria " + categoriaNadador);
	}

}
