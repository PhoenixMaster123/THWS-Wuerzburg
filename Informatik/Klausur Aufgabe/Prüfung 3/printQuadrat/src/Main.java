public class Main {
    public static void main(String[] args)
    {
        int zeilen = 4;
        printQuadrat(zeilen);
    }
    public static void printQuadrat(int zeilen)
    {
        for(int i = 1; i <= zeilen; i++)
        {
            for (int j = 1; j <= zeilen; j++)
            {
                if (i == 1 || i == zeilen)
                {
                    System.out.print("*");
                }
                else
                {
                    if (j == 1 || j == zeilen)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}