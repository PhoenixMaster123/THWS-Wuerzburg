public class PrimzahlThread_mit_Interface implements Runnable
{

    int zahlZumTesten;
    String ergebnis;
    public PrimzahlThread_mit_Interface(int zahlZumTesten)
    {
        this.zahlZumTesten = zahlZumTesten;
    }
    public boolean testeObPrimzahl()
    {
        if(zahlZumTesten < 2)
        {
            return false;
        }
        for (int devisor = 2; devisor < zahlZumTesten; devisor++)
        {
            if(zahlZumTesten % devisor == 0)
            {
                return false;
            }
        }
        return true;
    }
    @Override
    public void run()
    {
        boolean istPrimzahl = testeObPrimzahl();
        //Ergebnis einsammeln
        ergebnis = zahlZumTesten + " ist " + (istPrimzahl ? "eine " : "keine ") + "Primzahl.";
    }
}
