package Exercise_4;

import java.util.Scanner;

public class Criba {

    /**
     * En este metodo, dado un vector de numero enteros empezando en 2, se descarta sus multiplos, se encuentra
     * el siguiente entero no descartado y se descarta todos sus multiplos. Esto se repite hasta que pasa de
     * la raiz cuadrada del valor máximo.
     *
     * @param numeroMaximo es el numero que ingresamos para generar numeros -> e.j. de 1 a 100 (100 es el numero max)
     * @return Nos devuelve los números que quedan sin descartar, es decir, los numeros primos
     */
    public static int[] generarPrimos(int numeroMaximo) {
        int i;
        int j;
        int tamañoMaximoArray;

        if (numeroMaximo >= 2) {
            tamañoMaximoArray = numeroMaximo + 1;
            boolean[] esPrimo = new boolean[tamañoMaximoArray];

            for (i = 0; i < tamañoMaximoArray; i++) {
                esPrimo[i] = true;
                esPrimo[0] = esPrimo[1] = false;
            }

            double sqrtDim = Math.sqrt(tamañoMaximoArray) + 1;
            for (i = 2; i < sqrtDim; i++) {
                if (esPrimo[i]) {
                    for (j = 2 * i; j < tamañoMaximoArray; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }

            int cuantosPrimosHay = contarCuantosPrimosHay(tamañoMaximoArray, esPrimo);

            int[] primos = new int[cuantosPrimosHay];
            for (i = 0, j = 0; i < tamañoMaximoArray; i++) {
                if (esPrimo[i]) {
                    primos[j++] = i;
                }
            }
            return primos;

        } else {
            return new int[0];
        }
    }

    /**
     * En este método se cuentan cuantos números primos hay
     *
     * @param tamañoMaximoArray toma como parametro el tamaño del array, se le sumara 1 por la longitud
     *                          -> e.j. 20 -> será 21
     * @param esPrimo array de booleanos que tiene los numeros primos (que son los no descartados)
     * @return devuelve la cantidad de no descartados que ha encontrado en el array booleana, de esta manera sabemos
     *         cuales son los números primos.
     */
    private static int contarCuantosPrimosHay(int tamañoMaximoArray, boolean[] esPrimo) {
        int cuantosPrimosHay = 0;
        for (int i = 0; i < tamañoMaximoArray; i++) {
            if (esPrimo[i]) {
                cuantosPrimosHay++;
            }
        }
        return cuantosPrimosHay;
    }

    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);

        System.out.print("Introduce el número para la criba de Erastótenes: ");
        int datoUsuario = lecturaTeclado.nextInt();
        int vector[] = new int[datoUsuario];

        System.out.println("\nVector inicial hasta: " + datoUsuario);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }

        vector = generarPrimos(datoUsuario);
        System.out.println("\nVector de primos hasta: " + datoUsuario);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}
