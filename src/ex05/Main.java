package ex05;

public class Main {
	public static void main(String[] args) {
        int vetor [] = {25, 5, 30, 8, 20, 31, 3, 99,  100, 200, 205, 198};

		quickSort(vetor, 0, vetor.length - 1);

        for (int j = 0; j < vetor.length; j++) {
			System.out.println(vetor[j]);
		}
    }

    public static void quickSort(int vetor[], int ini, int fim) {
        int divisao; 
		if (ini < fim) { 
			divisao = particao(vetor, ini, fim); 
			quickSort (vetor, ini, divisao-1); 
			quickSort (vetor, divisao+1, fim); 
		}
    }	

    public static int particao(int[] vetor, int ini, int fim) {
        int pivo = vetor[ini],i = ini+1, f = fim, aux; 
		while (i<=f) { 
			while (i <= fim && vetor[i] <= pivo) 
				++i; 
			while (pivo < vetor[f]) 
				--f; 
			if (i < f){ 
				aux = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = aux; 
				++i; 
				--f;
			}	 
		} 
		if (ini != f){
			vetor[ini] = vetor[f];
			vetor[f] = pivo;
		} 
		return f; 
    }
}