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
    public void überschneidenTest()
    {

        assertTrue(Strecke.überschneiden(3,5));
        assertFalse(Strecke.überschneiden(4,4));
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