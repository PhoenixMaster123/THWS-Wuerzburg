package org.example;

import java.util.Random;

public class Cyborg implements MenschInterface, RoboterInterface
{
    Mensch menschTeil;
    Roboter roboterTeil;

    public Cyborg(Mensch menschTeil, Roboter roboterTeil)
    {
        this.menschTeil = menschTeil;
        this.roboterTeil = roboterTeil;
    }
    @Override
    public void Arbeiten() {

    }

    @Override
    public void Autofahren() {

    }

    @Override
    public Reaktion entscheide(Gefahrensituationen gefahrensituationen) {

        Reaktion menschEntscheidung = menschTeil.entscheide(gefahrensituationen);
        Reaktion roboterEntscheidung = roboterTeil.entscheide(gefahrensituationen);

        if(menschEntscheidung == roboterEntscheidung)
        {
            return menschEntscheidung;
        }
        else
        {
            Random random = new Random();

            return random.nextBoolean() ? menschEntscheidung : roboterEntscheidung;
        }
    }

    @Override
    public void Essen() {

    }

    @Override
    public void Schlafen() {

    }

    @Override
    public void Aufladen() {

    }

    @Override
    public void Warten() {

    }
}
