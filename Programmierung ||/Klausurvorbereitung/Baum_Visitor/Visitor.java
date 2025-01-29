package Klausurvorberaitung.Baum_Visitor;

public interface Visitor<T>
{
    public void visit(Baum.Knoten<T> current);
}
