public class LinkedList
{
    Knoten last;
        // a) einfuegen-Methode
        public void einfuegen(String name) {
            Knoten newKnoten = new Knoten(name);

            if (last == null) {
                last = newKnoten;
            } else {
                Knoten current = last;
                while (current.prev != null) {
                    current = current.prev;
                }
                current.prev = newKnoten;
            }
        }
    @Override
    public String toString() {
        // Initialisieren Sie eine leere Zeichenkette, die das Ergebnis speichern wird
        String result = "";
        // Initialisieren Sie eine Referenz auf den letzten Knoten der Liste
        Knoten current = last;
        // Verwenden Sie eine Schleife, um die Liste rückwärts zu durchlaufen
        while (current != null) {
            // Fügen Sie den Namen des aktuellen Knotens, gefolgt von einem Leerzeichen, zu dem Ergebnis hinzu
            // Wenn der Knoten null ist, fügen Sie einen leeren String hinzu, sonst fügen Sie den Namen des Knotens hinzu
            result += current.name + " ";
            // Setzen Sie die Referenz auf den Vorgängerknoten
            current = current.prev;
        }
        // Entfernen Sie das überflüssige Leerzeichen am Ende des resultierenden Strings
        return result;
    }
}