import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunktTest {
    Punkt punkt = new Punkt();

    @Test
    public void testValidCoordinates()
    {
        try {
            punkt.verschiebePunkt(1980,1080);
        }
        catch (RuntimeException ignored)
        {
            fail();
        }
    }
    @Test
    public void testNegativeXCoordinate()
    {
        try {
            punkt.verschiebePunkt(-1, 2342);
            fail("Expected RuntimeException, but no exception was thrown");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testNegativeYCoordinate()
    {
        try {
            punkt.verschiebePunkt(50, -1);
            fail("Expected RuntimeException, but no exception was thrown");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void verschiebePunktXGreaterThanBoundTest()
    {
        try {
            punkt.verschiebePunkt(1981, 500);
            fail("Expected RuntimeException, but no exception was thrown");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
    @Test
    public void verschiebePunktYGreaterThanBoundTest()
    {
        try {
            punkt.verschiebePunkt(1980, 1081);
            fail("Expected RuntimeException, but no exception was thrown");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

    /*
    @Test
    public void testValidCoordinates() {
        assertDoesNotThrow(() -> punkt.verschiebePunkt(1980, 1080));
    }

    @Test
    public void testNegativeXCoordinate() {
        assertThrows(RuntimeException.class, () -> punkt.verschiebePunkt(-100, 200));
    }

    @Test
    public void testNegativeYCoordinate() {
        assertThrows(RuntimeException.class, () -> punkt.verschiebePunkt(100, -200));
    }

    @Test
    public void testXCoordinateGreaterThan1920() {
        assertThrows(RuntimeException.class, () -> punkt.verschiebePunkt(2000, 200));
    }

    @Test
    public void testYCoordinateGreaterThan1080() {
        assertThrows(RuntimeException.class, () -> punkt.verschiebePunkt(100, 1500));
    }

     */
}
