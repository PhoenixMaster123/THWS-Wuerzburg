public class Liste
{
    Personenknoten startListe; // Represents the starting node of the list

    public void Sort (int alter, String nachname)
    {
        Personenknoten newNode = new Personenknoten(alter, nachname);

        if (startListe == null)
        {
            startListe = newNode;
        }
        else if(alter < startListe.alter)
        {
            newNode.next = startListe;
            startListe.prev = newNode;
            startListe = newNode;
        }
        else
        {
            Personenknoten current = startListe;

            while (current.next != null && current.next.alter < alter)
            {
                current = current.next;
            }
            newNode.next = current.next;
            if (current.next != null)
            {
                current.next.prev = newNode;
            }
            newNode.prev = current;
            current.next = newNode;
        }
    }
    /*
    Inserts a new Personenknoten into the list in a sorted manner based on the age.
    If the list is empty, it creates a new node as the starting node.
    If the age is less than the age of the starting node,
    it inserts the new node at the beginning.
    Otherwise, it iterates through the list to find the correct position
    for the new node.
     */

    public Personenknoten findPersonByLastName(String nachname)
    {
        Personenknoten current = startListe;

        while (current != null)
        {
            if (current.nachname.equals(nachname))
            {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void printForward() {
        Personenknoten current = startListe;

        while (current != null) {
            System.out.println("Age: " + current.alter + ", Last Name: " + current.nachname);
            current = current.next;
        }
    }

    public void printBackward() {
        Personenknoten current = startListe;

        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.println("Age: " + current.alter + ", Last Name: " + current.nachname);
            current = current.prev;
        }
    }
}





