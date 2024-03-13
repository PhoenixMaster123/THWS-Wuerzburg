public class Kugelvolumen
{
    public static double berechneKugelvolumen(double radius)
    {
        if(radius < 0)
        {
            return 0;
        }
        return  (4.0/3.0) * Math.PI * radius * radius * radius;
    }
}
