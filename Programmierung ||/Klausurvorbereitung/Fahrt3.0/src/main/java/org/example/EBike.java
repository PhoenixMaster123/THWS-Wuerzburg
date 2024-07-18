package org.example;

public class EBike extends Fahrrad implements ElektroFahrzeug
{
    @Override
    public void kehreZurückZurLadestation() {

    }
    @Override
    public double entgelten(Fahrt fahrt)
    {
        return 0;
    }
}
