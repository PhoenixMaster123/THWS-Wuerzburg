import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String matriculationNr = scanner.nextLine();
        String email = scanner.nextLine();

        formatName(firstName, secondName);
        formatNameWithMatriculationNr(firstName, secondName, matriculationNr);
        formatNameWithMatriculationNrAndMail(firstName, secondName, matriculationNr, email);
    }

    private static void formatNameWithMatriculationNrAndMail(String firstName, String secondName, String matriculationNr, String email) {
        System.out.println(firstName + ", " + secondName + " (" + matriculationNr + "):" + email);
    }

    private static void formatNameWithMatriculationNr(String firstName, String secondName, String matriculationNr) {
        System.out.println(firstName + ", " + secondName + " (" + matriculationNr + ")");
    }

    private static void formatName(String firstName, String secondName) {
        System.out.println(firstName + ", " + secondName);
    }
}