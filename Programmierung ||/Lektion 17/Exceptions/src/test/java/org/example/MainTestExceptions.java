package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTestExceptions
{
    @Test
    public void NumberFormatExceptionTest()
    {
        String eingabe = "2a";
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt(eingabe);
        });
    }
    @Test
    public void ArrayIndexOutOfBoundsExceptionTest()
    {
        int[] nums = {1, 2 , 3};
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        {
            int zahl = nums[3];
        });
    }
    @Test
    public void NullPointerExceptionTest()
    {
        String str = null;
        assertThrows(NullPointerException.class, () ->
        {
            int length = str.length();
        });
    }
    @Test
    public void OutOfMemoryErrorTest()
    {
        assertThrows(OutOfMemoryError.class, () -> {
            int[] arr = new int[Integer.MAX_VALUE];
        });
    }
    @Test
    public void FileNotFoundExceptionTest(){
        File file = new File("pattern.txt");
        assertThrows(FileNotFoundException.class, () ->
        {
            Scanner scanner = new Scanner(file);
        });
    }
    @Test
    public void ArithmeticExceptionTest()
    {
        assertThrows(ArithmeticException.class, () ->
        {
            int result = 15 / 0;
        });
    }
}