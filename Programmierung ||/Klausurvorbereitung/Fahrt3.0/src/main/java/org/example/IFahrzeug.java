package org.example;

import java.util.ArrayList;
import java.util.List;

public interface IFahrzeug
{
    public List<Fahrt> getFahrtenbuch();
    List<Fahrt> fahrtenBuch = new ArrayList<>();
    public double entgelten(Fahrt fahrt);
    public void trageFahrtInFahrtenbuch(Fahrt neu);
}
