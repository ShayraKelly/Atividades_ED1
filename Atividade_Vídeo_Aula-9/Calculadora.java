import java.util.Scanner;
import java.util.Stack;

public class Calculadora {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o tipo de notação (infixa, posfixa, prefixa):");
            String tipoNotacao = scanner.nextLine().trim().toLowerCase();

            System.out.println("Digite a expressão (use espaços entre tokens, ex: '3 + 5'):");
            String expressao = scanner.nextLine().trim();

            try {
                double resultado;
                String infixa, posfixa, prefixa;

                switch (tipoNotacao) {
                    case "infixa":
                        posfixa = converterParaPosfixa(expressao);
                        resultado = calcularPosfixa(posfixa);
                        infixa = expressao;
                        prefixa = converterParaPrefixa(expressao);
                        break;

                    case "posfixa":
                        resultado = calcularPosfixa(expressao);
                        infixa = converterParaInfixa(expressao, "posfixa");
                        posfixa = expressao;
                        prefixa = converterParaPrefixa(infixa);
                        break;

                    case "prefixa":
                        infixa = converterParaInfixa(expressao, "prefixa");
                        posfixa = converterParaPosfixa(infixa);
                        resultado = calcularPosfixa(posfixa);
                        prefixa = expressao;
                        break;

                    default:
                        throw new IllegalArgumentException("Tipo de notação inválido.");
                }

                System.out.println("Resultado: " + resultado);
                System.out.println("Notação Infixa: " + infixa);
                System.out.println("Notação Pós-fixa: " + posfixa);
                System.out.println("Notação Pré-fixa: " + prefixa);

            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Erro ao calcular a expressão: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }

    private static double calcularPosfixa(String expressao) {
        Stack<Double> pilha = new Stack<>();
        String[] tokens = expressao.split("\\s+");

        for (String token : tokens) {
            if (isNumero(token)) {
                pilha.push(Double.valueOf(token));
            } else {
                if (pilha.size() < 2) {
                    throw new ArithmeticException("Expressão inválida: operandos insuficientes.");
                }
                double operando2 = pilha.pop();
                double operando1 = pilha.pop();
                pilha.push(realizarOperacao(operando1, operando2, token));
            }
        }

        if (pilha.size() != 1) {
            throw new ArithmeticException("Expressão inválida: sobram elementos na pilha.");
        }

        return pilha.pop();
    }

    private static double realizarOperacao(double operando1, double operando2, String operador) {
        return switch (operador) {
            case "+" -> operando1 + operando2;
            case "-" -> operando1 - operando2;
            case "*" -> operando1 * operando2;
            case "/" -> {
                if (operando2 == 0) throw new ArithmeticException("Divisão por zero");
                yield operando1 / operando2;
            }
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }

    private static boolean isNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String converterParaPosfixa(String expressao) {
        Stack<String> operadores = new Stack<>();
        StringBuilder posfixa = new StringBuilder();
        String[] tokens = expressao.split("\\s+");

        for (String token : tokens) {
            if (isNumero(token)) {
                posfixa.append(token).append(" ");
            } else if ("(".equals(token)) {
                operadores.push(token);
            } else if (")".equals(token)) {
                while (!operadores.isEmpty() && !"(".equals(operadores.peek())) {
                    posfixa.append(operadores.pop()).append(" ");
                }
                operadores.pop(); // Remove "("
            } else {
                while (!operadores.isEmpty() && prioridade(operadores.peek()) >= prioridade(token)) {
                    posfixa.append(operadores.pop()).append(" ");
                }
                operadores.push(token);
            }
        }

        while (!operadores.isEmpty()) {
            posfixa.append(operadores.pop()).append(" ");
        }

        return posfixa.toString().trim();
    }

    private static int prioridade(String operador) {
        return switch (operador) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    private static String converterParaPrefixa(String expressao) {
        // Implementação da conversão infixa -> prefixa (dependente do Shunting-Yard modificado)
        return "Conversão para pré-fixa não implementada";
    }

    private static String converterParaInfixa(String expressao, String tipoAtual) {
        // Implementação da conversão de prefixa/posfixa -> infixa
        return "Conversão para infixa não implementada";
    }
}