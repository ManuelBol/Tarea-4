import java.util.Scanner;

/**
 * Clase que se encarga de generar todos los numeros primos desde 1 hasta el numero introducido por el usuario.
 * @author Manuel B
 * @version 1.0 02/03/2024
 */
public class Criba {

    /**
     *Metodo que se encarga de generar el array con la lista de numeros primos hasta el valor max introducido
     * como parametro.
     * @param max Valor maximo de la lista de primos a mostrar, introducido por el usuario.
     * @return Devuelve un array de tipo int con los números primos comprendidos entre 1 y max.
     */
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

    /**
     *Metodo nicializar el Array con tododos los elementos a true.
     * @param arrayLength Longitud del array, usada para realizar el recorrido del mismo.
     * @param esPrimo Array de tipo booleano a inicializar
     */
    //Inicializar el array con todos los elementos a True.
    public static void inicializarArrayTrue(int arrayLength, boolean[] esPrimo) {
        for (int i = 0; i < arrayLength; i++) {
            esPrimo[i] = true;
        }
    }

    /**
     * Metodo que realiza la criba de todos los numeros no primos, cambiando a false el estado de los mismos.
     * @param arrayLength Longitud del array, usada para realizar el recorrido del mismo.
     * @param esPrimo Array de tipo booleano sobre el cual realizar la criba
     */
    //Cambiar a False todos los no primos.
    public static void cribaPrimos(int arrayLength, boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(arrayLength) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < arrayLength; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    /**
     * Metodo que realiza la cuenta total de los números que si son primos.
     * @param arrayLength Longitud del array usada, usada para realizar el recorrido del mismo.
     * @param esPrimo Array de tipo booleano sobre el cual realizar el computo.
     * @return Devuelve un valor int con la cantidad de numeros primos.
     */
    //Devolver la cantidad de numeros primos.
    public static int getCuentaPrimos(int arrayLength, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Metodo que inicializa el array primos con los numeros primos contenidos en esPrimo.
     * @param arrayLength Longitud del Array, usada para el recorrido del mismo.
     * @param esPrimo Array del cual obtener cada uno de los numeros primos.
     * @param primos Array a inicializar con los numeros primos contenidos en esPrimo.
     */
    //Inicializar el array con los numeros primos
    public static void inicializarArrayPrimos(int arrayLength, boolean[] esPrimo, int[] primos) {
        for (int i = 0, j = 0; i < arrayLength; i++) {
            if (esPrimo[i]) {
                primos[j] = i;
                j++;
            }
        }
    }

    /**
     * Programa main para realizar la solicitud del valor hasta el cual generar los numeros primos,
     * mostrar todos los numeros contenidos entre 1 y el valor introducido y posteriormente mostrar
     * solo los numeros primos.
     */
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