package org.example;
import org.example.Baum.Knoten;
public interface Visitor<T>
{
    public void visit(Knoten<T> current);
}
