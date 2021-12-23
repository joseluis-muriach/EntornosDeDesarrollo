import java.util.Scanner;

public class Capitulo3 {
    public static void main(String[] args) {

        String practica = "";
        float nTeoria = 0f;
        float nTrabajos = 0f;
        float notaFinal = 0f;


        Scanner inputValue = new Scanner(System.in);
        System.out.println("Nota Práctica (A o NA)");
        System.out.print("--> ");
        practica = inputValue.next();

        System.out.println("Nota Teoría");
        System.out.print("--> ");
        nTeoria = inputValue.nextFloat();

        System.out.println("Nota Trabajo");
        System.out.print("--> ");
        nTrabajos = inputValue.nextFloat();


        if (practica.equals("NA")) {
            notaFinal = 4;
        } else {
            if (nTeoria < 4.5) {
                notaFinal = nTeoria;
            } else {
                notaFinal = nTeoria + nTrabajos;
            }
        }
        if (notaFinal >= 10) {
            System.out.println("Nota final: Matricula de Honor");
        } else {
            System.out.println("Nota final: " + notaFinal);
        }
    }
}