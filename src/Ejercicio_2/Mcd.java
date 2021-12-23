package Ejercicio_2;

public class Mcd {

    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int calculoMcd() {
        return Euclides(a, b);
    }

    private int Euclides(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int rest = a % b;
            return Euclides(b, rest);
        }
    }
}
