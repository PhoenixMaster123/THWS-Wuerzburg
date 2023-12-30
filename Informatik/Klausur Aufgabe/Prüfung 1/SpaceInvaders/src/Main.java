import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpaceInvaders spaceInvaders = new SpaceInvaders();
        // Print the initial state
        System.out.println(spaceInvaders);

        char command = ' ';
        while (command != 'x')
        {
            // Move
            spaceInvaders.bewege(command = scanner.nextLine().charAt(0));
            // Print the updated state
            System.out.println(spaceInvaders);
        }
    }
}