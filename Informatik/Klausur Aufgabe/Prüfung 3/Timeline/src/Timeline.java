public class Timeline
{
    Post neuePost;

    public void fuegePostEin(Post post)
    {
        if(neuePost == null)
        {
            neuePost = post;
        }
        else
        {
            post.vorgaenger = neuePost;
            neuePost = post;
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
