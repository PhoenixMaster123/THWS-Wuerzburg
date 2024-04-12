import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TickerTest
{
     final int INVALID_SIZE = -70;
     final int SIZE = 45;
     final int DEFAULT_SIZE = 200;

     @Test
     public void testTickerMessageSizeAtLeast2002()
     {
         Ticker ticker = new Ticker(SIZE);
         assertEquals(SIZE, ticker.getSize(), "The expected ticker size is: " + SIZE);
         assertEquals(SIZE, ticker.getNachricht().length, "The expected message length is " + SIZE);
     }

    @Test
    public void testTickerMessageSizeAtLeast200()
{
    Ticker ticker = new Ticker(INVALID_SIZE);
    assertEquals(DEFAULT_SIZE, ticker.getSize(), "The expected ticker size is: " + DEFAULT_SIZE);
    assertEquals(DEFAULT_SIZE, ticker.getNachricht().length, "The expected message length is " + DEFAULT_SIZE);
}
@Test
    public void testInitializitionMessage()
{
    Ticker ticker = new Ticker(SIZE);
    char[] newMessage = new char[SIZE];

    ticker.getNachricht();

    // Klausur relevant
    assertArrayEquals(newMessage, ticker.getNachricht(), "The message is not expected one");
}
@Test
public void testSetMessageLessThanTicketSize()
{
    Ticker ticker = new Ticker(SIZE);
    char[] newMessage = new char[] {'n','e','w',' ','m','e','s','s','a','g','e'};
    ticker.setNachricht(newMessage);
}
@Test
    public void testSetMessageThanTickerSize()
{
    Ticker ticker = new Ticker(SIZE);
    String newMessageStr = "Eine neue Nachricht. die mehr als 45 Zeichen hat";
    char[] newMessage = newMessageStr.toCharArray();
    ticker.setNachricht(newMessage);

    String expechtedStr;
}
    @Test
    public void testResetMessageWithDefautChar()
    {
        Ticker ticker = new Ticker(SIZE);
    }

    @Test
    public void testRotation()
{
    Ticker ticker = new Ticker(SIZE);

    String rotate = "Sonne ";
    String newMessageStr = "Sonne in Wuezburg";
    ticker.setNachricht(newMessageStr.toCharArray());

    ticker.rotateNachricht(rotate.length());

    String addition = "+".repeat(SIZE-newMessageStr.length());
    String expected = newMessageStr.substring(rotate.length()) + addition + rotate;

    assertArrayEquals(expected.toCharArray(),ticker.getNachricht());
}
}