package org.example;

public class CustomChangeCalculator implements ChangeCalculator {

    @Override
    public int[] getChange(int euros, int cent) {
        int[] change = new int[8];

        // Calculate 2-Euro coins
        change[7] = euros / 2;

        // Calculate 1-Euro coins
        change[6] = euros % 2;

        // Calculate 50-cent coins
        change[5] = cent / 50;
        cent -= change[5] * 50;

        // Calculate 20-cent coins
        change[4] = cent / 20;
        cent -= change[4] * 20;

        // Calculate 10-cent coins
        change[3] = cent / 10;
        cent -= change[3] * 10;

        // Calculate 5-cent coins
        change[2] = cent / 5;
        cent -= change[2] * 5;

        // Calculate 2-cent coins
        change[1] = cent / 2;
        cent -= change[1] * 2;

        // Remaining cent as 1-cent coins
        change[0] = cent % 2;

        return change;
    }
}
