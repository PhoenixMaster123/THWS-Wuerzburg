public class Post
{
    String text;
    String absender;
    String empfaenger;

    Post vorgaenger;

    public Post (String absender, String empfaenger, String text)
    {
        this.text = text;
        this.absender = absender;
        this.empfaenger = empfaenger;
    }

    public String postInfo()
    {
        String result = "";
        result += absender;
        result += " -> ";
        result += empfaenger;
        result += "\n";
        result += text;

        return result;
    }
}
