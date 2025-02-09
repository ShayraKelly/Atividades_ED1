public class TorreDeHanoi {

    public static void main(String[] args) {
        long numeroDeDiscos;
        numeroDeDiscos = 41;
        long starTime = System.currentTimeMillis();
        long totalMovimentos;
        totalMovimentos = torreDeHanoi((int) numeroDeDiscos, 'A', 'C', 'B');
        long tempoFinal;
        long endTime = System.currentTimeMillis();
        tempoFinal = endTime - starTime;
        long horas;
        horas = tempoFinal / 3600000;
        long minutos;
        minutos = (tempoFinal % 3600000) / 60000;
        long segundos;
        segundos = ((tempoFinal % 3600000) % 60000) / 1000;
        long milissegundos;
        milissegundos = tempoFinal % 1000;
        System.out.println("Número de discos: " + numeroDeDiscos);
        System.out.println("Total de movimentos: " + totalMovimentos + " movimentos");
        System.out.println("Tempo de execução: " + horas + "h " + minutos + "min " + segundos + "s " + milissegundos + "ms");
        
    }

    public static long torreDeHanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            return 1;
        }
        long movimentosAux1 = torreDeHanoi(n - 1, origem, auxiliar, destino);
        int movimentosAtual = 1;
        long movimentosAux2 = torreDeHanoi(n - 1, auxiliar, destino, origem);
        return movimentosAux1 + movimentosAtual + movimentosAux2;
    }
}
