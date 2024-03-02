import java.util.Scanner;

public class Criba {

    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max) {

        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];

            // Inicializar el array
            for (int i = 0; i < dim; i++) {
                esPrimo[i] = true;
            }

            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = false;
            esPrimo[1] = false;

            // Criba
            for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (int j = 2 * i; j < dim; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }

            // ¿Cuántos primos hay?
            int cuenta = 0;
            for (int i = 0; i < dim; i++) {
                if (esPrimo[i]) {
                    cuenta++;
                }
            }

            // Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (int i = 0, j = 0; i < dim; i++) {
                if (esPrimo[i]) {
                    primos[j++] = i;
                }
            }
            return primos;

        } else { // max < 2
            return new int[0];  // Vector vacío
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

/*Modificaciones:
* Separar asignacion a false de 0 y 1
* Eliminar declaración de int i, j y declararlos dentro de cada for.*/