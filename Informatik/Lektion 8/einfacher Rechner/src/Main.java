import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int result = 0;
        int counter = 0;
        for (int i = 0; i < args.length-1; i++)
        {
            if(args[args.length-1].equals("+"))
            {

               result += Integer.parseInt(args[i]);
            }
            else {
                if (counter >= 1)
                {
                    result -= Integer.parseInt(args[i]);
                }
                else
                {
                    result = Integer.parseInt(args[i]);
                    counter++;
                }


            }
        }
        System.out.println(result);
    }
}