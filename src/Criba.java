import java.util.Scanner;

public class Criba {

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max) {

        if (max >= 2) {
            boolean[] esPrimo = new boolean[max + 1];

            inicializarArrayTrue(esPrimo);

            // 0 y 1 no son primos
            esPrimo[0] = false;
            esPrimo[1] = false;

            cribaPrimos(esPrimo);

            int cantidadPrimos = getCuentaPrimos(esPrimo);


            int[] primos = new int[cantidadPrimos];
            inicializarArrayPrimos(esPrimo, primos);

            return primos;

        } else { // max < 2
            return new int[0];  // Vector vacío
        }
    }


    //Inicializar el array con todos los elementos a True.
    private static void inicializarArrayTrue(boolean[] esPrimo) {
        for (int i = 0; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
    }

    //Cambiar a False todos los no primos.
    private static void cribaPrimos(boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < esPrimo.length; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    //Devolver la cantidad de numeros primos.
    private static int getCuentaPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    //Inicializar el array con los numeros primos
    private static void inicializarArrayPrimos(boolean[] esPrimo, int[] primos) {
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j] = i;
                j++;
            }
        }
    }


    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        //Solicitud de número
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();

        //Array con longitud = numero introducido
        int[] vector = new int[dato];

        //Mostrar todos los numeros antes de realizar la criba
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if ( (i % 10) == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }

        //Mostrar todos los numeros primos
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if ( (i % 10) == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}