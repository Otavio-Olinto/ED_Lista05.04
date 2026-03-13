package otavio.ordenar.quicksort;

public class QuickSort {

	public QuickSort() {
		super();// TODO Auto-generated constructor stub
	}
	
	public int[] ordenar(int[] vetor, int inicio, int fim) {
		
		if(fim>inicio) {
			int pivo = dividir(vetor, inicio, fim); 
			ordenar(vetor, inicio, pivo-1); // Subvetores à Esquerda
			ordenar(vetor, pivo+1, fim); 	// Subvetores à Direita
		}
		
		return vetor;
	}
	
	// Função que analisa qual a posição correta do pivô
	private int dividir(int[] vetor, int inicio, int fim) {
		
		// Criando e adicionando a posição do Pivô, Ponteiro de Esquer e de Direita
		int pivo = inicio;
		int pontEsq = pivo+1;
		int pontDir = fim;
		
		while(pontEsq<=pontDir) {
			
			while(pontEsq<=pontDir && vetor[pontEsq]<=vetor[pivo]) {
				pontEsq++;
			}
			
			while(pontDir>=pontEsq && vetor[pontDir]>vetor[pivo]) {
				pontDir--;
			}
			
			if(pontDir>pontEsq) {
				trocar(vetor, pontEsq, pontDir);
				pontEsq++;
				pontDir--;
			}
		}
		
		trocar(vetor, pivo, pontDir);
		
		return pontDir;
	}
	
	// Função que realiza a troca dos valores quando encontrato a posição correta do pivô
	private void trocar(int[] vetor, int i, int j) {
		
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
}
