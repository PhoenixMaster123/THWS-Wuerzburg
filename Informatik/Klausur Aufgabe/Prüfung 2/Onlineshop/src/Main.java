public class Main {
    public static void main(String[] args) {

        String s = "1,99";
        char[] result = wandleUmInCents(s);
        System.out.println(String.valueOf(result));
    }
    public static char[] wandleUmInCents(String produktPreise)
    {
        String result = produktPreise.replace(",", "").replace(" ", "");

        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0')
        {
            startIndex++;
        }

        // Construct the char array
        char[] ch = new char[result.length() - startIndex];
        for (int i = startIndex; i < result.length(); i++)
        {
            ch[i - startIndex] = result.charAt(i);
        }

        return ch;
    }

}
/////////////////////////////////////////////////////// Variant 2 - ohne replace //////////////////////////////////
/*

public class Main {
    public static void main(String[] args) {
        String eingabe = "1,99";
        char[] ch = wandleUmInCents(eingabe);
        System.out.println(String.valueOf(ch));
    }

    public static char[] wandleUmInCents(String eingabe)
    {
        char[] ch = eingabe.toCharArray();
        int counter = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ',' || (ch[i] == '0'))
            {
                counter++;
                ch[i] = ' ';
            }
        }
        char[] result = new char[ch.length-counter];

        int count = 0;
        for (int i = 0; i < ch.length; i++)
        {

            if (ch[i] == ' ')
            {
                continue;
            }
            else
            {
                result[count] = ch[i];
                count++;
            }
        }

        return result;
    }
    /*
