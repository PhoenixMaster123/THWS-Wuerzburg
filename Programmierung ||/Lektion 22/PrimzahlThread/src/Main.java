public class Main {
    public static void main(String[] args) {

        System.out.println("Mit Vererbung:");
        ///////////////////////////////////// Vererbung /////////////////////////
        PrimzahlThread_mit_Vererbung zahl1 = new PrimzahlThread_mit_Vererbung(341);
        zahl1.start();
        PrimzahlThread_mit_Vererbung zahl2 = new PrimzahlThread_mit_Vererbung(633910099);
        zahl2.start();

        try
        {
            zahl1.join();
            zahl2.join();

            // Ab dieser Stelle sind beide Threads durchgelaufen und deren Ergebnis kann ausgegeben werden.
            System.out.println(zahl1.ergebnis);
            System.out.println(zahl2.ergebnis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        // Das muss nicht funktionieren. Wir bekommen null
        //System.out.println(zahl1.ergebnis);
        //System.out.println(zahl2.ergebnis);
        System.out.println();
        System.out.println("Mit Interface:");
        ///////////////////////////////////// Interface ///////////////////////////////////////////

        PrimzahlThread_mit_Interface pr1 = new PrimzahlThread_mit_Interface(341);
        PrimzahlThread_mit_Interface pr2 = new PrimzahlThread_mit_Interface(633910099);

        Thread t1 = new Thread(pr1);
        Thread t2 = new Thread(pr2);
        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();

            System.out.println(pr1.ergebnis);
            System.out.println(pr2.ergebnis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Anonyme Klasse:");
        ///////////////////////////////////// Anonyme Klasse ///////////////////////////////////////////
        int zahlZumTesten = 633910099;
        Thread k1 = new Thread()
        {
            @Override
            public void run()
            {
                boolean istPrimzahl;
                if(zahlZumTesten < 2)
                {
                    istPrimzahl = false;
                }
                else
                {
                    istPrimzahl = true;
                }
                for (int devisor = 2; devisor < zahlZumTesten; devisor++)
                {
                    if (zahlZumTesten % devisor == 0) {
                        istPrimzahl = false;
                        break;
                    }
                }
                System.out.println(zahlZumTesten + " ist " + (istPrimzahl ? "eine " : "keine ") + "Primzahl.");
            }
        };
        k1.start();

        try {
            k1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ///////////////////////////////////// Locale Klasse ///////////////////////////////////////////
       System.out.println();
       System.out.println("Locale Klasse:");
        class LocalClassThread extends Thread { // Wir machen das, wenn wir das Ergebnis einsammeln
            boolean istPrimzahl;
            String ergebnis;

            public boolean testeObPrimzahl() {
                if (zahlZumTesten < 2) {
                    return false;
                }
                for (int devisor = 2; devisor < zahlZumTesten; devisor++) {
                    if (zahlZumTesten % devisor == 0) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public void run() {
                istPrimzahl = testeObPrimzahl();
                //Ergebnis einsammeln
                ergebnis = zahlZumTesten + " ist " + (istPrimzahl ? "eine " : "keine ") + "Primzahl.";
            }

            public boolean getErgebnis() {
                return istPrimzahl;
            }
        }
        LocalClassThread t = new LocalClassThread();
        t.start();
        try
        {
            t.join();
            System.out.println(t.getErgebnis());
            System.out.println(t.ergebnis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}
