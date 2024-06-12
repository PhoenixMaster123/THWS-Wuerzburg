package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatTheListTest
{
    @Test
    public void testFlattenMethodWithMixedTypes() {
        List<List<Object>> mixedTypeLists = new ArrayList<>();
        mixedTypeLists.add(Arrays.asList(1, "apple", true));
        mixedTypeLists.add(Arrays.asList("banana", false));
        mixedTypeLists.add(Arrays.asList(3.14, "kiwi"));
        assertEquals(Arrays.asList(1, "apple", true, "banana", false, 3.14, "kiwi"), FlatTheList.flatten(mixedTypeLists));
        assertEquals(Arrays.asList(1, "apple", true, "banana", false, 3.14, "kiwi"), FlatTheList.flatten2(mixedTypeLists));

    }
    @Test
    public void testFlattenMethodWithStrings()
    {
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList("apple", "banana", "cherry"));
        listOfLists.add(Arrays.asList("orange", "grape"));
        listOfLists.add(Arrays.asList("kiwi", "melon", "pineapple"));

        List<String> expected = Arrays.asList("apple", "banana", "cherry","orange", "grape","kiwi", "melon", "pineapple");
        assertEquals(expected,FlatTheList.flatten(listOfLists));
    }
    @Test
    public void testFlattenMethodWithIntegers()
    {
        List<List<Integer>> listOfIntLists = new ArrayList<>();
        listOfIntLists.add(Arrays.asList(1, 2, 3));
        listOfIntLists.add(Arrays.asList(4, 5));
        listOfIntLists.add(Arrays.asList(6, 7, 8));

        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8);
        assertEquals(expected,FlatTheList.flatten(listOfIntLists));
    }
    @Test
    public void testFlattenMethodWithNestedEmptyLists() {
        List<List<String>> nestedEmptyLists = new ArrayList<>();
        nestedEmptyLists.add(Arrays.asList());
        nestedEmptyLists.add(Arrays.asList("apple", "banana"));
        nestedEmptyLists.add(Arrays.asList());
        assertEquals(Arrays.asList("apple", "banana"), FlatTheList.flatten(nestedEmptyLists));
    }
    @Test
    public void testFlattenMethodWithEmptyList() {
        List<List<String>> emptyListOfLists = new ArrayList<>();
        assertEquals(Collections.emptyList(), FlatTheList.flatten(emptyListOfLists));
    }
}