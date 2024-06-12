package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatTheList
{
    public static<E> List<E> flatten(List<List<E>> listen)
    {
        List<E> result = new ArrayList<>();

        for (List<E> list : listen)
        {
            result.addAll(list);
        }
        return result;
    }
    // This is Variant 2 using streams + Lambda + flatMap
    public static<E> List<E> flatten2(List<List<E>> listen)
    {
        List<E> result;
        result = listen.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        return result;
    }
}
