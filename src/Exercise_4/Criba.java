package Exercise_4;

import java.util.Scanner;

public class Criba {
    public static int[] generarPrimos(int numeroMaximo) {
        int i = 0;
        int j = 0;
        int dim = 0;

        if (numeroMaximo >= 2) {
            dim = numeroMaximo + 1;
            boolean[] esPrimo = new boolean[dim];

            for (i = 0; i < dim; i++){
                esPrimo[i] = true;
                esPrimo[0] = esPrimo[1] = false;
            }

            double sqrtDim = Math.sqrt(dim) + 1;
            for (i = 2; i < sqrtDim; i++) {
                if (esPrimo[i]) {
                    for (j = 2 * i; j < dim; j += i){
                        esPrimo[j] = false;
                    }
                }
            }

            int cuantosPrimosHay = 0;
            for (i = 0; i < dim; i++) {
                if (esPrimo[i]){
                    cuantosPrimosHay++;
                }
            }
            int[] primos = new int[cuantosPrimosHay];
            for (i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i]){
                    primos[j++] = i;
                }
            }
            return primos;

        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el número para la criba de Erastótenes: ");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];

        System.out.println("\nVector inicial hasta: " + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0){
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta: " + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}
