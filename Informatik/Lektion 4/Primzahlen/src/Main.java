import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int num = Integer.parseInt(sc.nextLine());

        if (num <= 1) {
            System.out.println("Untersuchte Zahl ist keine Primzahl!");
        }
        boolean k = false;
        while (k != true) {


            for (int i = 2; i < num; i++) {

                if (num % i == 0) {
                    System.out.println("Untersuchte Zahl ist keine Primzahl!");
                    break;
                }

                System.out.println("Untersuchte Zahl ist eine Primzahl!");
                k = true;
                break;
            }
            if (k == true) {
                break;
            }
            num = sc.nextInt();
        }
    }
}

