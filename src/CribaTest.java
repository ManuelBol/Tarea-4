import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CribaTest {

    @Test
    void generarPrimos() {
        Criba a = new Criba();

        //Si el valor introducido es 2 o mayor (En este caso 30)
        int[] expected = {2,3,5,7,11,13,17,19,23,29};
        int[] actual = a.generarPrimos(30);
        assertArrayEquals(expected, actual);

        //Si el valor introducido es menor que 2 (En este caso 1)
        int[] expected1 = {};
        int[] actual1 = a.generarPrimos(1);
        assertArrayEquals(expected1, actual1);



    }


}