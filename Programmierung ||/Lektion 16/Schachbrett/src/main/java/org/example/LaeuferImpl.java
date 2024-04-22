package org.example;

public class LaeuferImpl extends AbstractFigur implements Laeufer {
    public LaeuferImpl(int x, int y) {
        super(x, y);
    }
    @Override
    public Brett gibErlaubteFelder() {
        Brett brett = new Brett();

        // Loop through all directions until reaching the edge of the board
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                // Skip checking the current position (dx & dy both 0)
                if (dx == 0 && dy == 0) continue;

                int tempX = x + dx;
                int tempY = y + dy;

                // Loop while within board boundaries
                while (tempX >= 1 && tempX <= 8 && tempY >= 1 && tempY <= 8) {
                    brett.markiereFeld(tempX, tempY);
                    tempX += dx;
                    tempY += dy;
                }
            }
        }

        return brett;
    }

    public static void main(String[] args) {
        LaeuferImpl l = new LaeuferImpl(4, 5);
        Brett brett = l.gibErlaubteFelder();
        for (int j = 1; j <= 8; j++) {
            for (int i = 1; i <= 8; i++) {
                if (brett.gibFeld(i, j)) System.out.print("x");
                else System.out.print("o");
            }
            System.out.println();
        }
    }
}
