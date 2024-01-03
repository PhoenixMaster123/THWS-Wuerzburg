public class Main {
    public static void main(String[] args)
    {
        int feld = -27;
        System.out.println(feld(feld));
    }
    public static int feld(int value) {
        int counter = 0;
        if (value > 0) {
            for (int i = 0; i <= value; i++) {
                if (i % 3 == 0) {
                    counter++;
                }

            }
        }
        else if (value < 0) {
            for (int i = value; i <= 0; i++) {
                if (i % 3 == 0) {
                    counter++;
                }
            }
        }
        else
        {
            counter++;
        }
        return counter;
    }
}