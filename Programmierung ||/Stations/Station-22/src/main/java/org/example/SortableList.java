package org.example;

import java.util.ArrayList;
import java.util.List;

public class SortableList<E extends Comparable<E>>
{
    ArrayList<E> defaultList = new ArrayList<>();
    public void addElements(List<E> list)
    {
        defaultList.addAll(list);
    }
    //public void sortList()
}