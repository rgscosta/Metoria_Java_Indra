package Exercicios_Condicionais;


/*
1. Escreva um programa que verifique a idade de um nadador e classifique-o em uma das
seguintes categorias:
a) infantil A = 5 a 7 anos
b) infantil B = 8 a 10 anos
c) juvenil A = 11 a 13 anos
d) juvenil B = 14 a 17 anos
e) adulto = maiores de 18 anos
O nadador 1 tem 15 anos, o nadador 2 tem 23 e o nadador 3 tem 6 anos.*/

public class ClassificacaoNadador_Predicate {
	
	public static void main(String[] args) {

		int nadadorIdade1 = 15;
		int nadadorIdade2 = 23;
		int nadadorIdade3 = 6;

		classificarNadador(nadadorIdade1);
		classificarNadador(nadadorIdade2);
		classificarNadador(nadadorIdade3);
	}

	public static void classificarNadador(int idade) {
		String categoriaNadador;

		switch (idade) {
		case 5:
		case 6:
		case 7:
			categoriaNadador = "Infantil A";
			break;
		case 8:
		case 9:
		case 10:
			categoriaNadador = "Infantil B";
			break;
		case 11:
		case 12:
		case 13:
			categoriaNadador = "Juvenil A";
			break;
		case 14:
		case 15:
		case 16:
		case 17:
			categoriaNadador = "Juvenil B";
			break;
		default:
			categoriaNadador = "Adulto";
			break;
		}

		System.out.println("O nadador com idade " + idade + " anos pertence a  categoria " + categoriaNadador);
	}

}
