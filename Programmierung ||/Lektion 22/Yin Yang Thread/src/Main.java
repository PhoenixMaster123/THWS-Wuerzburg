

public class Main {
    public static void main(String[] args)
    {
        /////////////////////////////// Vererbung ////////////////////////////
        MessagePrinterVererbung yangThread = new MessagePrinterVererbung(" Yang ");
        MessagePrinterVererbung yinThread = new MessagePrinterVererbung(" Yin ");
        yangThread.start();
        yinThread.start();


        /////////////////////////////// Interface ////////////////////////////
        MessagePrinterInterface y1 = new MessagePrinterInterface("Yin");
        MessagePrinterInterface y2 = new MessagePrinterInterface("Yang");

        Thread t1 = new Thread(y1);
        Thread t2 = new Thread(y2);

        // t1.setDaemon(true);
        // t2.setDaemon(true);
        // -> if the both Threads are Daemon then after Exception the program will terminate and not continue,
        //    because we don't have any longer any User Threads

        t1.start(); // User Thread -> that means: if I receive Exception is not going to stop
        /*try {
            t1.join(500); // if I add join until the t1 is finished t2 is not going to start
                               // I can add also time before t2 to start
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
         */
        t2.start(); // User Thread

        /////////////////////////////// Anonyme Klasse  ////////////////////////////


        Thread k1 = new Thread(() -> {
            while (true)
            {
                System.out.println("Yin");
                MessagePrinterAnonymeClass();
            }
        });
        try {
            k1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            while (true)
            {
                System.out.println("Yang");
                MessagePrinterAnonymeClass();
            }
        }).start();

        /////////////////////////////// Locale Klasse  ////////////////////////////

        class LocalClassThread extends Thread
        {
            @Override
            public void run()
            {
                System.out.println("Yin");
                MessagePrinterAnonymeClass();
                System.out.println("Yang");
            }
        }

    }
    private static void MessagePrinterAnonymeClass()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}