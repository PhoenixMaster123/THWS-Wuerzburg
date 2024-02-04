public class Polonaise
{
    Roboter start;

    public Polonaise()
    {
        this.start = null;
    }

    public void anhaengen(String name, int gross)
    {
        Roboter newRoboter = new Roboter(name, gross);
        if (start == null) // Liste ist leer
        {
            start = newRoboter; // neuer Roboter ist der erste
        }
        else if (start.getGross() > gross) // neuer Roboter ist kleiner als der erste
        {
            newRoboter.setNext(start); // neuer Roboter wird vor dem ersten eingefügt
            start = newRoboter; // neuer Roboter ist der neue erste
        }
        else // neuer Roboter ist größer oder gleich dem ersten
        {
            Roboter current = start; // aktueller Roboter ist der erste
            while (current.getNext() != null && current.getNext().getGross() <= gross) // solange es einen Nachfolger gibt und dieser kleiner oder gleich dem neuen Roboter ist
            {
                current = current.getNext(); // gehe zum nächsten Roboter
            }
            // current ist jetzt der Vorgänger des neuen Roboters
            newRoboter.setNext(current.getNext()); // neuer Roboter bekommt den Nachfolger von current
            current.setNext(newRoboter); // current bekommt den neuen Roboter als Nachfolger
        }
    }
    public void vorstellen()
    {
        if (start == null) // Liste ist leer
        {
            System.out.println("Es gibt keine Roboter in der Polonaise.");
        }
        else // Liste ist nicht leer
        {
            Roboter current = start; // aktueller Roboter ist der erste
            while (current != null) // solange es einen aktuellen Roboter gibt
            {
                System.out.println(current.toString()); // rufe die toString-Methode des aktuellen Roboters auf
                current = current.getNext(); // gehe zum nächsten Roboter
            }
        }
    }


}
