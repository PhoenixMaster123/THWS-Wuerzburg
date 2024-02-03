public class Timeline
{
    Post neuePost;

   public void fuegePostEin(Post post) {
        if (neuePost == null) {
            neuePost = post; // Wenn die Liste leer ist, wird die neue Post zum Kopf
        } else {
            Post current = neuePost; // Sonst, erstelle eine temporäre Variable, die auf den Kopf zeigt
            while (current.vorgaenger != null) { // Durchlaufe die Liste, bis du den letzten Knoten erreichst
                current = current.vorgaenger;
            }
            current.vorgaenger = post; // Füge die neue Post nach dem letzten Knoten ein
            post.vorgaenger = null; // Setze den Vorgänger der neuen Post auf null, um das Ende der Liste zu zeigen
        }
    }

    public void gibAus()
    {
        Post temp = neuePost;
        while(temp != null)
        {
            System.out.println(temp.postInfo());
            System.out.println();
            temp = temp.vorgaenger;
        }
    }

}
