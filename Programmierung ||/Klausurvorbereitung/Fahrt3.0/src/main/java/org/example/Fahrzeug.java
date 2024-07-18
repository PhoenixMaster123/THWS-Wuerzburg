package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Fahrzeug implements IFahrzeug
{
    List<Fahrt> fahrtenBuch = new ArrayList<>();

    public void trageFahrtInFahrtenbuch(Fahrt neu) {
        fahrtenBuch.add(neu);
    }
    public List<Fahrt> getFahrtenbuch() {
        return fahrtenBuch;
    }
}
