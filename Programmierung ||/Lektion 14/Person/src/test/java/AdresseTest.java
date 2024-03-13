import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdresseTest
{
    Adresse adresse;

    @Test
    public void correctTest()
    {
        try {
            adresse = new Adresse("Zürnstraße", "5e12r", "97074","Würzburg");
        }
        catch (RuntimeException e)
        {
            fail();
        }
    }
    @Test
    public void failStrasseBuchstabeTest()
    {
        try {
            adresse = new Adresse("zürnstraße", "5e12r", "97074","Würzburg");
            fail();
        }
        catch (RuntimeException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void failOrtBuchstabeTest()
    {
        try {
            adresse = new Adresse("Zürnstraße", "5e12r", "97074","würzburg");
            fail();
        }
        catch (RuntimeException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void failHausnummerDigitTest()
    {
        try {
            adresse = new Adresse("Zürnstraße", "T2e12r", "97074","Würzburg");
            fail();
        }
        catch (RuntimeException e)
        {
            assertTrue(true);
        }
    }
}