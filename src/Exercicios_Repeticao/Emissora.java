package Exercicios_Repeticao;

public class Emissora {

	int numeroEmissora;
	int qtdAssistindo;

	public Emissora(int numeroEmissora, int qtdAssistindo) {
		this.numeroEmissora = numeroEmissora;
		this.qtdAssistindo = qtdAssistindo;
	}

	public int getNumeroEmissora() {
		return numeroEmissora;
	}

	public int getQtdAssistindo() {
		return qtdAssistindo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Emissora: " + numeroEmissora + "\n" + "Quantidade de telespectadores: " + qtdAssistindo;
	}
}
