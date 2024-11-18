package Lektion19.genericStack;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> implements Stack<T>{
    private final List<T> genericList = new ArrayList<>();

    @Override
    public void push(T element) {
        genericList.add(element);
    }
    @Override
    public T pop() {
      return genericList.removeLast();
    }

    public List<T> getGenericList() {
        return genericList;
    }
}
