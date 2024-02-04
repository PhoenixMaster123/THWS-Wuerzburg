public class Main {
    public static void main(String[] args) {

    }
    //////////////////////////////////// Baum Insert ///////////////////////////
    /*
    public void Insert(Knoten neu) {
        if (root == null)
        {
            root = neu;
        }
        else
        {
            Insert(root, neu);
        }
    }

    private void Insert(Knoten temp, Knoten neu) {
        if (neu.getWord().compareTo(temp.getWord()) < 0)
        {
            if (temp.left == null)
            {
                temp.left = neu;
            }
            else
            {
                Insert(temp.left, neu);
            }
        }
        else
        {
            if (temp.right == null)
            {
                temp.right = neu;
            }
            else
            {
                Insert(temp.right, neu);
            }
        }
    }
     */
    //////////////////////////////// Insert dopple verkettete Liste + sort ////////////////
/*
    public void Insert (int alter, String nachname)
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
 */
    /////////////////////////////////// Insert at the Beginning ////////////////////
    // Beispiel:
    /*
     if (neuePost == null) {
        neuePost = post; // Wenn die Liste leer ist, wird die neue Post zum Kopf
    } else {
        post.vorgaenger = neuePost; // Setze die aktuelle neue Post vor den aktuellen Kopf
        neuePost = post; // Aktualisiere den Kopf auf die neue Post
    }

     */

   /////////////////////////////////// Insert at the End ////////////////////
   // Beispiel:
    /*
    public void fuegePostEin(Post post) {
        if (neuePost == null) {
            neuePost = post; // Wenn die Liste leer ist, wird die neue Post zum Kopf
        } else {
            Post current = neuePost; // Sonst, erstelle eine temporäre Variable, die auf den Kopf zeigt
            while (current.vorgaenger != null) { // Durchlaufe die Liste, bis du den letzten Knoten erreichst
                current = current.vorgaenger;
            }
            current.vorgaenger = post; // Füge die neue Post nach dem letzten Knoten ein
        }
    }

 */
/*
    public void einfuegen(String name, double distanz) {
        Zielort newZielort = new Zielort(name, distanz);
        if (firstZielort == null) {
            firstZielort = newZielort;
        }
        else {
            Zielort currentZielort = firstZielort;
            while (currentZielort.getNext() != null) {
                currentZielort = currentZielort.getNext();
            }
            currentZielort.setNext(newZielort);
        }
    }
 */
}