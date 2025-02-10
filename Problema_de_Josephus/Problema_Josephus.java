import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problema_Josephus {

    public static void main(String[] args) {
        int numPessoas = 20;
        List<Pessoa> roda = new ArrayList<>();

        for (int i = 1; i <= numPessoas; i++) {
            roda.add(new Pessoa("Pessoa " + i, "Telefone " + i, "Endereço " + i, "CPF " + i));
        }

        Pessoa sobrevivente = josephus(roda); 

        if (sobrevivente != null) {
            System.out.println("O sobrevivente é:");
            System.out.println("Nome: " + sobrevivente.getNome());
            System.out.println("Telefone: " + sobrevivente.getTelefone());
            System.out.println("Endereço: " + sobrevivente.getEndereco());
            System.out.println("CPF: " + sobrevivente.getCpf());
        } else {
            System.out.println("Nenhum sobrevivente encontrado.");
        }
    }

    public static Pessoa josephus(List<Pessoa> roda) {
        Random random = new Random();
        int indiceAtual = 0;

        while (roda.size() > 1) {
            int m = random.nextInt(roda.size()) + 1;
            int pessoaEliminada = (indiceAtual + m - 1) % roda.size();

            roda.remove(pessoaEliminada);
            indiceAtual = pessoaEliminada % roda.size();
        }

        if (!roda.isEmpty()) {
            return roda.get(0);
        } else {
            return null; 
        }
    }
}