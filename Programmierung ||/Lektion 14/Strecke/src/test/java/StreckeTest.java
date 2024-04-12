import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreckeTest
{

    @Test
    public void correctgespeichertePunkte() {
        Strecke strecke = new Strecke(2, 5);
        assertEquals(2, strecke.anfangspunktA);
        strecke = new Strecke(5, 2);
        assertEquals(2, strecke.anfangspunktA);
        strecke = new Strecke(2, 5);
        assertEquals(5, strecke.endpunktB);
        strecke = new Strecke(5, 2);
        assertEquals(5, strecke.endpunktB);
        strecke = new Strecke(4,4);
        assertEquals(4, strecke.endpunktB);
    }
    @Test
    public void überschneidenTest() {
        Strecke s1 = new Strecke(1, 3);
        Strecke s2 = new Strecke(2, 4);
        Strecke s3 = new Strecke(4, 6);
        Strecke s4 = new Strecke(7, 9);
        Strecke s5 = new Strecke(4, 8);

        assertTrue(Strecke.überschneiden(s1,s2));
        assertTrue(Strecke.überschneiden(s1,s3));
        assertTrue(Strecke.überschneiden(s1,s4));
        assertTrue(Strecke.überschneiden(s1,s5));

        assertTrue(Strecke.überschneiden(s2,s1));
        assertTrue(Strecke.überschneiden(s3,s1));
        assertTrue(Strecke.überschneiden(s4,s1));
        assertTrue(Strecke.überschneiden(s5,s1));
    }
    @Test
    public void toStringTestRichtigeWerte()
    {
        Strecke strecke = new Strecke(3,5);
        assertEquals("3--5", strecke.toString());
        strecke = new Strecke(2,8);
        assertEquals("2------8",strecke.toString());
    }
    @Test
    public void toStringTestEinzigeWerte()
    {
        Strecke strecke = new Strecke(4,4);
        assertEquals("4", strecke.toString());
    }
}
