import java.util.Scanner;

public class AtividadeCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;
        String notacao, num1, num2;

        do{
            System.out.println("\n\n1 - Notação pre-fixa");
            System.out.println("2 - Notação Infixa");
            System.out.println("3 - Notação pos-fixa");
            System.out.println("0 - Fim");
            System.out.printf("Selecione uma das Opções: ");
            op = scanner.nextInt();
            scanner.nextLine();

            PilhaOperacoes pilha = new PilhaOperacoes();
            switch (op) {
                case 0: 
                    System.out.println("FIM!!!\n\n");
                    break;
            
                case 1: 
                    System.out.printf("Operação: ");
                    notacao = scanner.nextLine();
                    System.out.println("Valor 1: ");
                    num1 = scanner.nextLine();
                    System.out.println("Valor 2: ");
                    num2 = scanner.nextLine();
                    pilha.push(0, notacao);
                    pilha.push(1, num1);
                    pilha.push(2, num2);
                    pilha.prefixa();
                    break;
            
                case 2: 
                    System.out.println("Valor 1: ");
                    num1 = scanner.nextLine();
                    System.out.printf("Operação: ");
                    notacao = scanner.nextLine();
                    System.out.println("Valor 2: ");
                    num2 = scanner.nextLine();
                    pilha.push(0, num1);
                    pilha.push(1, notacao);
                    pilha.push(2, num2);
                    pilha.infixa();
                    break;
            
                case 3: 
                    System.out.println("Valor 1: ");
                    num1 = scanner.nextLine();
                    System.out.println("Valor 2: ");
                    num2 = scanner.nextLine();
                    System.out.printf("Operação: ");
                    notacao = scanner.nextLine();
                    pilha.push(0, num1);
                    pilha.push(1, num2);
                    pilha.push(2, notacao);
                    pilha.posfixa();
                    break;
            
                default:
                    System.out.println("Opção não válida!\n\n");
                    break;
            }
        }while(op != 0);

        
    }

    public static void PreFixa() {
        System.out.println("\n\nNotação pre-fixa selecionada");
    }

    public static void infixa() {
        System.out.println("\n\nNotação infixa selecionada");
    }

    public static void PosFixa() {
        System.out.println("\n\nNotação pos-fixa selecionada");
    }
}