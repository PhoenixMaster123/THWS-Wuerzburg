public class Schachbrett {
    //markiert alle bedrohten Felder
    boolean[][] brett = new boolean[8][8];

    public void setzeTurm(int x, int y) {
        // Markiere alle Felder in der gleichen Zeile
        for (int i = 0; i < 8; i++) {
            brett[x][i] = true;
        }

        // Markiere alle Felder in der gleichen Spalte
        for (int i = 0; i < 8; i++) {
            brett[i][y] = true;
        }

        // Markiere das Feld auf der übergebenen Position
        brett[x][y] = true;
    }
    public String toString() {
        String result = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result += brett[i][j] ? "x " : "o ";
            }
            result += "\n";
        }

        return result;
    }
}

