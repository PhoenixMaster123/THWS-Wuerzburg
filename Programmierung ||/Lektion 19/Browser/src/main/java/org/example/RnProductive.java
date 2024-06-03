package org.example;

public class RnProductive implements IRandomNumber
{

    @Override
    public double getRandomNumber() {
        return Math.random();
    }
}
