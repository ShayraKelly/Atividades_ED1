class Celula {
    private char elemento;
    private Celula proxima;

    Celula(char elemento) {
        this.elemento = elemento;
    }

    char getElemento() {
        return elemento;
    }

    Celula getProxima() {
        return proxima;
    }

    void setProxima(Celula proxima) {
        this.proxima = proxima;
    }
}
