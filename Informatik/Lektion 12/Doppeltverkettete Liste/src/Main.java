public class Main {
    public static void main(String[] args) {


        Liste personListe = new Liste();

        // Insert five Personenknoten objects into the list
        personListe.Sort(25, "Doe");
        personListe.Sort(30, "Smith");
        personListe.Sort(22, "Johnson");
        personListe.Sort(35, "Brown");
        personListe.Sort(28, "Williams");

        String searchLastName = "Smith";
        Personenknoten foundPerson = personListe.findPersonByLastName(searchLastName);

        // Search a person by his last name
        if (foundPerson != null)
        {
            System.out.println("Found person with last name " + searchLastName + ":");
            System.out.println("Age: " + foundPerson.alter + ", Last Name: " + foundPerson.nachname);
        }
        else
        {
            System.out.println("Person with last name " + searchLastName + " not found.");
        }
        System.out.println();

        // Print the list forward
        System.out.println("Forward:");
        personListe.printForward();

        // Print the list backward
        System.out.println("\nBackward:");
        personListe.printBackward();

    }
}