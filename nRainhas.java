import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nRainhas {

	static class ResultadoUma {
		int[] solucao;
		int iteracoes;

		ResultadoUma(int[] solucao, int iteracoes) {
			this.solucao = solucao;
			this.iteracoes = iteracoes;
		}
	}

	static class ResultadoTodas {
		List<int[]> solucoes;
		int iteracoes;

		ResultadoTodas(List<int[]> solucoes, int iteracoes) {
			this.solucoes = solucoes;
			this.iteracoes = iteracoes;
		}
	}

	static ResultadoUma resolverUma(int n) {
		int[] pos = new int[n];
		Arrays.fill(pos, -1);
		boolean[] coluna = new boolean[n];
		boolean[] diag1 = new boolean[2 * n - 1];
		boolean[] diag2 = new boolean[2 * n - 1];
		int[] iteracoes = {0};

		if (buscarUma(0, n, pos, coluna, diag1, diag2, iteracoes)) {
			return new ResultadoUma(Arrays.copyOf(pos, n), iteracoes[0]);
		}

		return new ResultadoUma(new int[0], iteracoes[0]);
	}

	static ResultadoTodas resolverTodas(int n) {
		List<int[]> solucoes = new ArrayList<>();
		int[] pos = new int[n];
		Arrays.fill(pos, -1);
		boolean[] coluna = new boolean[n];
		boolean[] diag1 = new boolean[2 * n - 1];
		boolean[] diag2 = new boolean[2 * n - 1];
		int[] iteracoes = {0};

		buscarTodas(0, n, pos, coluna, diag1, diag2, solucoes, iteracoes);
		return new ResultadoTodas(solucoes, iteracoes[0]);
	}

	static boolean buscarUma(int linha, int n, int[] pos, boolean[] coluna, boolean[] diag1, boolean[] diag2, int[] iteracoes) {
		if (linha == n) return true;

		for (int c = 0; c < n; c++) {
			iteracoes[0]++;
			int d1 = linha - c + n - 1;
			int d2 = linha + c;

			if (!coluna[c] && !diag1[d1] && !diag2[d2]) {
				pos[linha] = c;
				coluna[c] = diag1[d1] = diag2[d2] = true;

				if (buscarUma(linha + 1, n, pos, coluna, diag1, diag2, iteracoes)) {
					return true;
				}

				coluna[c] = diag1[d1] = diag2[d2] = false;
				pos[linha] = -1;
			}
		}

		return false;
	}

	static void buscarTodas(int linha, int n, int[] pos, boolean[] coluna, boolean[] diag1, boolean[] diag2, List<int[]> solucoes, int[] iteracoes) {
		if (linha == n) {
			solucoes.add(Arrays.copyOf(pos, n));
			return;
		}

		for (int c = 0; c < n; c++) {
			iteracoes[0]++;
			int d1 = linha - c + n - 1;
			int d2 = linha + c;

			if (!coluna[c] && !diag1[d1] && !diag2[d2]) {
				pos[linha] = c;
				coluna[c] = diag1[d1] = diag2[d2] = true;

				buscarTodas(linha + 1, n, pos, coluna, diag1, diag2, solucoes, iteracoes);

				coluna[c] = diag1[d1] = diag2[d2] = false;
				pos[linha] = -1;
			}
		}
	}

	static void mostrarTabuleiro(int[] solucao) {
		for (int l = 0; l < solucao.length; l++) {
			for (int c = 0; c < solucao.length; c++) {
				System.out.print(solucao[l] == c ? "Q " : ". ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 8;

		ResultadoUma uma = resolverUma(n);
		System.out.println("Uma solucao:");
		if (uma.solucao.length == 0) {
			System.out.println("Nenhuma solucao encontrada.");
		} else {
			mostrarTabuleiro(uma.solucao);
		}
		System.out.println("Iteracoes: " + uma.iteracoes);

		ResultadoTodas todas = resolverTodas(n);
		System.out.println();
		System.out.println("Total de solucoes: " + todas.solucoes.size());
		System.out.println("Iteracoes: " + todas.iteracoes);
		if (!todas.solucoes.isEmpty()) {
			System.out.println("Primeira solucao:");
			mostrarTabuleiro(todas.solucoes.get(0));
		}
	}
}