package Klausurvorberaitung.ss2020.Aufgabe3;

import java.util.ArrayList;
import java.util.Collection;

public class ImmutableList<E> extends ArrayList<E> {

    public ImmutableList(Collection<? extends E> c) {
        super(c); // Übernimmt die Elemente aus der übergebenen Collection
    }

    // Überschreiben der add-Methoden, um das Hinzufügen zu verhindern
    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Hinzufügen von Elementen ist nicht erlaubt.");
    }

}
