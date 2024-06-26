public class Strecke
{
    public int anfangspunktA;
    public int endpunktB;

    public Strecke(int anfangspunktA,int endpunktB)
    {
        if(anfangspunktA < endpunktB)
        {
            this.anfangspunktA = anfangspunktA;
            this.endpunktB = endpunktB;
        }
        else
        {
            this.anfangspunktA = endpunktB;
            this.endpunktB = anfangspunktA;
        }
    }
     public static boolean überschneiden(Strecke eins, Strecke zwei)
    {
        return (zwei.anfangspunktA <= eins.anfangspunktA || zwei.endpunktB >= eins.anfangspunktA);
    }
    public String toString()
    {
        String str = "";
        if(anfangspunktA == endpunktB)
        {
            return String.valueOf(anfangspunktA);
        }
        str += String.valueOf(anfangspunktA);
        for (int i = endpunktB - anfangspunktA; i > 0; i--)
        {
            str += "-";
        }
        str += String.valueOf(endpunktB);
        return str;
    }
}
