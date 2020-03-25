package Flik;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test
    public void testIsSameNumber() {
        int a = 128;
        int b = 128;
        int c = 500;
        boolean equal = Flik.isSameNumber(a, b);
        boolean nequal = Flik.isSameNumber(a, c);

        assertTrue(equal);
        assertFalse(nequal);
//        System.out.println(equal);
//        System.out.println(nequal);
    }
}


