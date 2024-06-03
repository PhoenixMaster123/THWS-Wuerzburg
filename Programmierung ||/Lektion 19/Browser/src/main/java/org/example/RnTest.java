package org.example;

public class RnTest implements IRandomNumber
{
    boolean google = false;
    public RnTest(boolean google)
    {
        this.google = google;
    }
    @Override
    public double getRandomNumber() {
        if(this.google)
        {
            return 0.4;
        }
        else
        {
            return 0.8;
        }
    }
}
