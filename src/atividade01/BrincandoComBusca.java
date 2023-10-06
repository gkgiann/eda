package atividade01;

public class BrincandoComBusca {

	public static void main(String[] args) {

		Busca_IF b = new Busca();
		final int numeroParaBuscar = -1;

		// final int[] vetor1000 = b.geraVetorNumericoOrdenado(100000000);
		final int[] vetor1000 = b.geraVetorNumericoOrdenado(5000);

		long antes, depois;

		antes = System.nanoTime();
		b.buscaLinear_iterativa(vetor1000, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaLinear_iterativa:\t" + (depois - antes));

		antes = System.nanoTime();
		b.buscaLinear_iterativa_duasPontas(vetor1000, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaLinear_iterativa2:\t" + (depois - antes));

		antes = System.nanoTime();
		b.buscaLinear_recursiva(vetor1000, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaLinear_recursiva:\t" + (depois - antes));

		antes = System.nanoTime();
		b.buscaBinaria_iterativa(vetor1000, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaBinaria_iterativa:\t" + (depois - antes));

		antes = System.nanoTime();
		b.buscaBinaria_recursiva(vetor1000, numeroParaBuscar);
		depois = System.nanoTime();
		System.out.println("buscaBinaria_recursiva:\t" + (depois - antes));

		// int somaDosNanoSegundos = 0;
		// for (int i = 1; i <= 50; i++) {
		// poẽ o algoritmo aqui
		// somaDosNanoSegundos += (depois - antes);
		// }

		// int mediaEmNanoSegundos = somaDosNanoSegundos / 50;
		// int mediaEmMiliSegundos = mediaEmNanoSegundos / 1000000;
		// int mediaEmSegundos = mediaEmMiliSegundos / 1000;

		// System.out.printf(
		// "Média de tempo de execução do algoritmo X\nEm nanosegundos: %d\nEm
		// milisegundos: %d\nEm segundos: %d",
		// mediaEmNanoSegundos, mediaEmMiliSegundos, mediaEmSegundos);

	}

}