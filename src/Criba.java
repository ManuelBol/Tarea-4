import java.util.Scanner;

public class Criba {

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max) {

        if (max >= 2) {
            int arrayLength = max + 1;
            boolean[] esPrimo = new boolean[arrayLength];

            inicializarArrayTrue(arrayLength, esPrimo);

            // 0 y 1 no son primos
            esPrimo[0] = false;
            esPrimo[1] = false;

            cribaPrimos(arrayLength, esPrimo);

            int cantidadPrimos = getCuentaPrimos(arrayLength, esPrimo);


            int[] primos = new int[cantidadPrimos];
            inicializarArrayPrimos(arrayLength, esPrimo, primos);

            return primos;

        } else { // max < 2
            return new int[0];  // Vector vacío
        }
    }


    //Inicializar el array con todos los elementos a True.
    private static void inicializarArrayTrue(int arrayLength, boolean[] esPrimo) {
        for (int i = 0; i < arrayLength; i++) {
            esPrimo[i] = true;
        }
    }

    //Cambiar a False todos los no primos.
    private static void cribaPrimos(int arrayLength, boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(arrayLength) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < arrayLength; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    //Devolver la cantidad de numeros primos.
    private static int getCuentaPrimos(int arrayLength, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    //Inicializar el array con los numeros primos
    private static void inicializarArrayPrimos(int arrayLength, boolean[] esPrimo, int[] primos) {
        for (int i = 0, j = 0; i < arrayLength; i++) {
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