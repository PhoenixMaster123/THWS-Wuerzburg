import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyList<E>
{
    List<E> list = new ArrayList<>();

    public boolean addAll(Collection<? extends E> c)
    {
        for (E e : c)
        {
            list.add(e);
        }
        return true;
    }
    public String toString()
    {
        return list.toString();
    }
}
