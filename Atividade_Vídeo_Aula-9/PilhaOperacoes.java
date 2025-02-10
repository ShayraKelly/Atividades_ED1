public class PilhaOperacoes {
    String[] pilha = new String[3];
    int num1, num2, top;
    String op;

    public void prefixa() {
        int num1_int = Integer.parseInt(this.pilha[1]);
        int num2_int = Integer.parseInt(this.pilha[2]);

        double result = calculo(num1_int, num2_int, this.pilha[0]);
        System.out.println("Operação Prefixa: " + result);

    }

    public void infixa() {
        int num1_int = Integer.parseInt(this.pilha[0]);
        int num2_int = Integer.parseInt(this.pilha[2]);
        
        double result = calculo(num1_int, num2_int, this.pilha[1]);
        System.out.println("Operação Infixa: " + result);
    }

    public void posfixa() {
        int num1_int = Integer.parseInt(this.pilha[0]);
        int num2_int = Integer.parseInt(this.pilha[1]);
        

        double result = calculo(num1_int, num2_int, this.pilha[2]);
        System.out.println("Operação Posfixa: " + result);
    }

    private double calculo(int num1, int num2, String op){
        if ("+".equals(op)) {
            return num1+num2;
        }
        else if ("-".equals(op)) {
            return num1-num2;
        }
        else if ("*".equals(op)) {
            return num1*num2;
        }
        else{
            return num1/num2;
        }
    }

    public int push(int top, String valores){
        this.top = top;
        
        if(this.top<0){
            this.top = 0;
        }
        
        if(this.top > 2){
            System.out.println("Pilha Cheia!");
            return(this.top--);
        }else{
            this.pilha[this.top]=valores;
            return(this.top);
        }
    }
}
