import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problemaTroco {

	static class Resultado {
		List<Integer> moedas;
		int iteracoes;

		Resultado(List<Integer> moedas, int iteracoes) {
			this.moedas = moedas;
			this.iteracoes = iteracoes;
		}
	}

	static Resultado troco(int valor, int[] moedas) {
		Arrays.sort(moedas);
		List<Integer> usadas = new ArrayList<>();
		int iteracoes = 0;

		for (int i = moedas.length - 1; i >= 0 && valor > 0; i--) {
			iteracoes++;
			while (valor >= moedas[i]) {
				usadas.add(moedas[i]);
				valor -= moedas[i];
				iteracoes++;
			}
		}

		return new Resultado(usadas, iteracoes);
	}

	static void mostrarResultado(int valor, int[] moedas) {
		Resultado r = troco(valor, Arrays.copyOf(moedas, moedas.length));
		System.out.println("Valor: " + valor);
		System.out.println("Moedas: " + Arrays.toString(moedas));
		System.out.println("Escolhidas: " + r.moedas);
		System.out.println("Quantidade: " + r.moedas.size());
		System.out.println("Iteracoes: " + r.iteracoes);
		System.out.println();
	}

	public static void main(String[] args) {
		int[] moedas = {1, 5, 10, 25, 100};

		if (args.length > 0) {
			int valor = Integer.parseInt(args[0]);
			mostrarResultado(valor, moedas);
			return;
		}

		mostrarResultado(289, moedas);
		mostrarResultado(87, new int[] {1, 5, 10, 25});
	}
}