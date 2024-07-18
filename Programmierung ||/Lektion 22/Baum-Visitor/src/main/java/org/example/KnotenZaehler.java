package org.example;

import org.example.Baum.Knoten;

public class KnotenZaehler<T> implements Visitor<T> {
    private int count = 0;

    @Override
    public void visit(Knoten<T> current) {
        count++;
    }

    public int getCount() {
        return count;
    }
}
