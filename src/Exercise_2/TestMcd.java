package Exercise_2;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestMcd {
    public static void main(String[] args) {

    }

    @Test
    public void testear() {
        Mcd mcd = new Mcd();

        mcd.setA(72);
        mcd.setB(16);
        assertEquals(8, mcd.calculoMcd());

    }

    @Test
    public void testear2() {

        Mcd mcdFalso = new Mcd();

        mcdFalso.setA(72);
        mcdFalso.setB(16);
        assertEquals(4, mcdFalso.calculoMcd());

    }

}
