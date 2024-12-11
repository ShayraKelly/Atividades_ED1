public class Exercicio_490 {
    public static void main(String[] args) {
        int tamanho = 8;
        char[] vetor = {'a', 'b', 'c', 'a', 'd', 'a', 'e', 'a'};
        char caractere = 'a';

        int totalSubstituido = substituiCaractere(vetor, tamanho, caractere);

        // Imprimir o vetor após a substituição
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println("\nTotal de caracteres retirados: " + totalSubstituido);
    }

    static int substituiCaractere(char[] vetor, int tamanho, char caractere) {
        // Verifica se o vetor é válido
        if (vetor == null || vetor.length != tamanho) {
            throw new IllegalArgumentException("Vetor inválido ou tamanho incorreto.");
        }

        int totalSubstituido = 0;

        // Substitui as ocorrências do caractere por '*'
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == caractere) {
                vetor[i] = '*';
                totalSubstituido++;
            }
        }

        return totalSubstituido;
    }
}