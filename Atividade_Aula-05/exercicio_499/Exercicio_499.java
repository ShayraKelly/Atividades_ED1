import java.util.Arrays;
import java.util.Scanner;

public class Exercicio_499 {
    public static void main(String[] args) {
        int[] vetor = new int[5];
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nMENU VETOR - FUNÇÃO");
            System.out.println("1. Dados do VETOR");
            System.out.println("2. Ordena VETOR");
            System.out.println("3. Imprime VETOR");
            System.out.println("4. Sai do programa");
            System.out.print("OPÇÃO: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    preencheVetor(vetor, scanner);
                    break;
                case 2:
                    ordenaVetor(vetor);
                    break;
                case 3:
                    imprimeVetor(vetor);
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    static void preencheVetor(int[] vetor, Scanner scanner) {
        System.out.println("Digite 5 números para preencher o vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }
    }

    static void ordenaVetor(int[] vetor) {
        Arrays.sort(vetor);
        System.out.println("Vetor ordenado.");
    }

    static void imprimeVetor(int[] vetor) {
        System.out.println("Vetor: " + Arrays.toString(vetor));
    }
}
