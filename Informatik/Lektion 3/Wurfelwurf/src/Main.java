import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int random = (int) (Math.random() * 6) + 1;
//////////////////////////////// Variant 1 ////////////////////////////
        if(random == 1)
        {
            System.out.println("Eins gewürfelt");
        }
        else if(random == 2)
        {
            System.out.println("Zwei gewürfelt");
        }
        else if(random == 3)
        {
            System.out.println("Drei gewürfelt");
        }
        else if(random == 4)
        {
            System.out.println("Vier gewürfelt");
        }
        else if(random == 5)
        {
            System.out.println("Fünf gewürfelt");
        }
        else
        {
            System.out.println("Sechs gewürfelt");
        }
        //////////////////////////////// Variant 2 ////////////////////////////
        /*
        int start = 1;
        int end = 7;

        Random generator = new Random();
        int random = generator.nextInt(end-start) + start;

        if(random == 1)
        {
            System.out.println("Eins gewürfelt");
        }
        else if(random == 2)
        {
            System.out.println("Zwei gewürfelt");
        }
        else if(random == 3)
        {
            System.out.println("Drei gewürfelt");
        }
        else if(random == 4)
        {
            System.out.println("Vier gewürfelt");
        }
        else if(random == 5)
        {
            System.out.println("Fünf gewürfelt");
        }
        else
        {
            System.out.println("Sechs gewürfelt");
        }
        */

    }
}
