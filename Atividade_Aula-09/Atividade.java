import java.util.Deque;
import java.util.ArrayDeque;

public class Atividade {
    public static void main(String[] args) {
        String exemplo1 = "UM CIENTISTA DA COMPUTAÇÃO DEVE RESOLVER OS PROBLEMAS LOGICAMENTE";
        String exemplo2 = "ESARF ATERCES ODALERAHCAB ME AICNEIC AD OAÇATUPMOC FI ONAIOG SUPMAC SOHNIRROM )OAN( HE MU SOD SEROHLEM SOSRUC ED OAÇATUPMOC OD ODATSE ED SAIOG";

        String resultado1 = invertePalavras(exemplo1);
        String resultado2 = invertePalavras(exemplo2);

        System.out.println("Exemplo 1: " + resultado1);
        System.out.println("Exemplo 2: " + resultado2);
    }

    static String invertePalavras(String texto) {
        String[] palavras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            resultado.append(inverteString(palavra)).append(" ");
        }

        return resultado.toString().trim();
    }

    static String inverteString(String str) {
        Deque<Character> pilha = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            pilha.push(c);
        }

        StringBuilder invertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            invertida.append(pilha.pop());
        }

        return invertida.toString();
    }
}