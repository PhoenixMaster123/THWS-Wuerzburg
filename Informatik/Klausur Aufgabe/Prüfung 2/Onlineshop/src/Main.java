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