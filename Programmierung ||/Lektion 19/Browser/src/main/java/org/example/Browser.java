package org.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Browser
{
    IRandomNumber rNCreator;

    Browser(IRandomNumber r)
    {
        this.rNCreator = r;
    }
    public Browser()
    {
        this.rNCreator = new RnProductive();
    }
    public Optional<URL> back()
    {
        Optional<URL> url = Optional.empty();
        try
        {
            if(this.rNCreator.getRandomNumber() < 0.5)
            {
                url = Optional.of(new URL("http://google.de"));
            }
            //simulate: fetch last URL from Stack
            //return Math.random() < 0.5 ? Optional.of(new URL("http://google.de")) : Optional.empty();
        }
        catch(MalformedURLException e)
        {
            return Optional.empty();
        }
        return url;
    }

   /* public String retrieveSite(Optional<URL> url)
    {
        //simulate download site:
        return url.toString();
    }

    */
    public String retrieveSite(URL url)
    {
        //simulate download site:
        return url.toString();
    }
}
