package com.mycompany.exercicio_497;

public class Exercicio_497 {
    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int tamanho = vetor.length;
        int chave = 5;

        int posicao = buscaBinaria(vetor, tamanho, chave);

        if (posicao != -1) {
            System.out.println("A chave " + chave + " foi encontrada na posição " + posicao);
        } else {
            System.out.println("A chave " + chave + " não foi encontrada no vetor.");
        }
    }

    static int buscaBinaria(int[] vetor, int tamanho, int chave) {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (vetor[meio] == chave) {
                return meio; // Chave encontrada, retorna a posição
            } else if (vetor[meio] < chave) {
                inicio = meio + 1; // A chave está à direita do meio
            } else {
                fim = meio - 1; // A chave está à esquerda do meio
            }
        }

        return -1; // Chave não encontrada
    }
}