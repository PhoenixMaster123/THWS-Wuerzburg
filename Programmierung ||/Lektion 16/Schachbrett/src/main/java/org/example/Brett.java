package org.example;

public class Brett
{
    boolean[][] brett = new boolean[8][8];

    public Brett()
    {

    }

    public void markiereFeld(int x, int y)
    {
        brett[x-1][y-1] = true;
    }

    public boolean gibFeld(int x, int y)
    {
        return brett[x-1][y-1];
    }

    public Brett kombiniere(Brett brettLaeufer) {
        Brett kombiniertesBrett = new Brett();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.brett[i][j]) {
                    kombiniertesBrett.markiereFeld(i + 1, j + 1);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (brettLaeufer.gibFeld(i + 1, j + 1)) {
                    kombiniertesBrett.markiereFeld(i + 1, j + 1);
                }
            }
        }
        return kombiniertesBrett;
    }

}
