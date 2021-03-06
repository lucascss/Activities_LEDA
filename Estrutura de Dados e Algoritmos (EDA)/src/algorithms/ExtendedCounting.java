package algorithms;

public class ExtendedCounting {

	private static int searchLargest(int[] array) {
		int maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior)
				maior = array[i];
		}
		return maior;
	}

	private static int searchSmall(int[] array) {
		int menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor)
				menor = array[i];
		}
		return menor;
	}

	// Para valores nao negativos...

	public void countingSort(int[] array, int leftIndex, int rightIndex) {
		if (array == null)
			return;

		if (leftIndex < rightIndex) {

			int menor = searchSmall(array); // Menor do array.
			int maior = searchLargest(array); // Maior do array.

			// Tamanho do array que sera usado para a contagem de ocorrencias.
			int tamanho = (maior - menor) + 1;

			int shift = menor;

			int[] count = new int[tamanho];

			// Frequencia
			for (int i = 0; i < array.length; i++)
				count[array[i] - shift]++;

			// Cumulativa
			for (int i = 1; i < count.length; i++)
				count[i] += count[i - 1];

			// Array usado para ordenacao.
			int[] sorted = new int[array.length];

			for (int i = 0; i < array.length; i++) {
				int x = array[i] - shift;
				int y = count[x];
				sorted[y - 1] = array[i];
				count[x]--;
			}

			// Rearrumando o array original...
			for (int i = 0; i < array.length; i++)
				array[i] = sorted[i];

		}
	}

}