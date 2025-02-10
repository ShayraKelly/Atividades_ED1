public class Lista_Encadeada {

    public static void main(String[] args) {
        int[] vetor = new int[1000];
        Gerador_Aleatorio gerador = new Gerador_Aleatorio(System.currentTimeMillis());

        for (int i = 0; i < 1000; i++) {
            vetor[i] = (gerador.proximoNumero() % 19999 - 9999);
        }

        System.out.println("Vetor gerado:");
        imprimirVetor(vetor);

        ListaEncadeada lista = new ListaEncadeada();
        for (int valor : vetor) {
            lista.inserirOrdenado(valor);
        }

        System.out.println("\nLista em ordem crescente:");
        lista.imprimirCrescente();

        System.out.println("\nLista em ordem decrescente:");
        lista.imprimirDecrescente();

        lista.removerPrimos();

        System.out.println("\nLista após remoção de primos:");
        lista.imprimirCrescente();
    }

    private static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static class No {
        int valor;
        No anterior;
        No proximo;

        public No(int valor) {
            this.valor = valor;
        }
    }

    private static class ListaEncadeada {
        No cabeca;
        No cauda;

        public void inserirOrdenado(int valor) {
            No novoNo = new No(valor);

            if (cabeca == null) { 
                cabeca = novoNo;
                cauda = novoNo;
            } else if (valor <= cabeca.valor) { 
                novoNo.proximo = cabeca;
                cabeca.anterior = novoNo;
                cabeca = novoNo;
            } else if (valor >= cauda.valor) { 
                novoNo.anterior = cauda;
                cauda.proximo = novoNo;
                cauda = novoNo;
            } else { 
                No atual = cabeca;
                while (atual.proximo != null && valor > atual.proximo.valor) {
                    atual = atual.proximo;
                }
                novoNo.proximo = atual.proximo;
                novoNo.anterior = atual;
                if (atual.proximo != null) {
                    atual.proximo.anterior = novoNo;
                }
                atual.proximo = novoNo;
            }
        }

        public void imprimirCrescente() {
            No atual = cabeca;
            while (atual != null) {
                System.out.print(atual.valor + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }

        public void imprimirDecrescente() {
            No atual = cauda;
            while (atual != null) {
                System.out.print(atual.valor + " ");
                atual = atual.anterior;
            }
            System.out.println();
        }

        public void removerPrimos() {
            No atual = cabeca;
            while (atual != null) {
                if (ehPrimo(atual.valor)) {
                    removerNo(atual);
                }
                atual = (atual.proximo);

            }
        }

        private void removerNo(No no) {
            if (no == cabeca) {
                cabeca = no.proximo;
                if (cabeca != null) cabeca.anterior = null;
            } else if (no == cauda) {
                cauda = no.anterior;
                if (cauda != null) cauda.proximo = null;
            } else {
                no.anterior.proximo = no.proximo;
                no.proximo.anterior = no.anterior;
            }
        }

        private boolean ehPrimo(int num) {
            if (num <= 1) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}