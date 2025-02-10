public class Gerador_Aleatorio {

    private long semente;

    public Gerador_Aleatorio(long semente) {
        this.semente = semente;
    }

    public void definirSemente(int semente) {
        this.semente = semente;
    }

    public int proximoNumero() {
        semente = (1103515245 * semente + 12345) & 0x7fffffff; 
        return semente;
    }

    public int proximoInteiro(int limite) {
        return proximoNumero() % limite;
    }

    public double proximoDecimal() {
        return (double) proximoNumero() / 2147483647.0; 
    }

    public boolean proximoBooleano() {
        return proximoNumero() % 2 == 0;
    }
}