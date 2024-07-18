public class MessagePrinterInterface implements Runnable
{
    String message;
    public MessagePrinterInterface(String message)
    {
        this.message = message;
    }
    @Override
    public void run()
    {
        while (true)
        {
            System.out.println(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
