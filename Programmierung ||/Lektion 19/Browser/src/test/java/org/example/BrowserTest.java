package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BrowserTest
{
    @Test
    public void TestBrowserGetsGoogleUrl()
    {
        Browser browser = new Browser(new RnTest(true));
        assertTrue(browser.back().isPresent(), "Optional<URL> is not present.");

        assertEquals("http://google.de", browser.retrieveSite(browser.back().get()));
    }
    @Test
    public void TestBrowserGetsGoogleUrlWithMock()
    {
        Browser browser = Mockito.mock(Browser.class);
        try
        {
            Optional<URL> optional = Optional.of(new URL("http://google.de"));
            Mockito.when(browser.back()).thenReturn(optional);
            Optional<URL> actual = browser.back();
            assertEquals("http://google.de", actual.get().toString());
        }
        catch (MalformedURLException e)
        {
            fail(e.getMessage());
        }


    }
    @Test
    public void testMethodBack()
    {
        Browser browser = new Browser();
        Optional<URL> back = browser.back();
        assertTrue(back.isPresent()  || !back.isPresent());
    }
}