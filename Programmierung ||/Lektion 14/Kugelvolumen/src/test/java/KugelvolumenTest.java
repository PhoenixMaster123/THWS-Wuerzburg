import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KugelvolumenTest
{
    @Test
    public void berechneKugelvolumenTest()
    {
        assertEquals(0.0, Kugelvolumen.berechneKugelvolumen(0), 0.0001); // delta = differenz(tolerance)
        assertEquals(4.1887902047863905, Kugelvolumen.berechneKugelvolumen(1), 0.0001);
        assertEquals(523.5987755982989, Kugelvolumen.berechneKugelvolumen(5), 0.0001);
        assertEquals(-4.1887902047863905, Kugelvolumen.berechneKugelvolumen(-1), 0.0001);
    }
}