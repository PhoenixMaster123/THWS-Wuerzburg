public class MessagePrinterVererbung extends Thread
{
    String message;

    public MessagePrinterVererbung(String message)
    {
        this.message = message;
        // Ich kann hier den Thread starten oder in main
        //start();
    }
    public void run()
    {
        //System.out.println(message);
        while (true)
        {
            System.out.print(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println();
        }
    }
}
