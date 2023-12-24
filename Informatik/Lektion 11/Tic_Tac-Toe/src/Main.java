import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size = 3;

        boolean[][][] gameBoard = initializeGameBoard(size);

        // 3D-Tic-Tac-Toe-Feld visualisieren
        printGameBoard(gameBoard);
    }
    private static boolean[][][] initializeGameBoard (int size)
    {
        boolean[][][] gameBoard = new boolean[size][size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++)
                {
                    gameBoard[i][j][k] = random.nextBoolean();
                }
            }
        }
        return gameBoard;
    }
    private static void printGameBoard(boolean[][][] gameBoard)
    {
        int size = gameBoard.length;

        for (int i = 0; i < size; i++)
        {
            System.out.println("Layer " + (i + 1) + ":");
            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++)
                {
                    if(gameBoard[i][j][k])
                    {
                        System.out.print("x ");
                    }
                    else
                    {
                        System.out.print("o ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}


