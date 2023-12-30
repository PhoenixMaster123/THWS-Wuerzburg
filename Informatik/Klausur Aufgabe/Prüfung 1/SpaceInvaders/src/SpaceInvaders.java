import javax.swing.plaf.PanelUI;

public class SpaceInvaders {
    int breit = 8;
    int spalten = 5;
    char[][] space = new char[spalten][breit];

    public SpaceInvaders() {
        Spielfeld(spalten, breit, space);
        toString();
    }

    public void Spielfeld(int breit, int spalten, char[][] space) {

        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                if (i == 0) {
                    space[i][j] = 'o';

                }
               /* else if (i == space.length-1)
                {
                    int position = (int) (Math.random() * breit);
                    space[i][position] = 'V';
                }
                */

                else {
                    space[i][j] = ' ';
                }

            }

        }
        int position = (int) (Math.random() * breit);
        space[4][position] = 'V';

    }

    public void bewege(char buchstabe) {
        int positionV = -1; // Initialize positionV to -1 to handle the case where 'V' is not found

// Find the column index of 'V'
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                if (space[i][j] == 'V') {
                    positionV = j;
                    break; // Once 'V' is found, exit the loop
                }
            }
        }

// Check if 'V' is found
        if (positionV != -1) {
            if (buchstabe == 'a' && positionV < space[0].length - 1) {
                // Move 'V' one position to the right if within bounds
                space[space.length - 1][positionV] = ' ';
                space[space.length - 1][positionV + 1] = 'V';
            } else if (buchstabe == 'd' && positionV > 0) {
                // Move 'V' one position to the left if within bounds
                space[space.length - 1][positionV] = ' ';
                space[space.length - 1][positionV - 1] = 'V';
            }
        }
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                result += space[i][j];
            }
            result += "\n";
        }

        return result;
    }

}

