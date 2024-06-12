package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList("apple", "banana", "cherry"));
        listOfLists.add(Arrays.asList("orange", "grape"));
        listOfLists.add(Arrays.asList("kiwi", "melon", "pineapple"));
        System.out.println(FlatTheList.flatten(listOfLists));
        List<List<Integer>> listOfIntLists = new ArrayList<>();
        listOfIntLists.add(Arrays.asList(1, 2, 3));
        listOfIntLists.add(Arrays.asList(4, 5));
        listOfIntLists.add(Arrays.asList(6, 7, 8));
        System.out.println(FlatTheList.flatten(listOfIntLists));
        List<List<Object>> mixedTypeLists = new ArrayList<>();
        mixedTypeLists.add(Arrays.asList(1, "apple", true));
        mixedTypeLists.add(Arrays.asList("banana", false));
        mixedTypeLists.add(Arrays.asList(3.14, "kiwi"));
        System.out.println(FlatTheList.flatten2(listOfIntLists));
    }
}