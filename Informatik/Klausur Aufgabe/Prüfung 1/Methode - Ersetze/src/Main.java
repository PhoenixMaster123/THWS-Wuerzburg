public class Main {
    public static void main(String[] args)
    {
        int zeichnen = ersetze("Graphik.Init.Datei.ini");
        System.out.println(zeichnen);
    }
    public static int ersetze(String text)
    {
        int count = 0;
        char[] arr = text.toCharArray();
        boolean k = false;

        for(int i = arr.length-1; i > 1; i--)
        {

            if(arr[i] == '.')
            {
                count++;
                if (count > 1)
                {
                    k = true;
                    arr[i] = '_';
                }
            }
        }

        System.out.println(String.valueOf(arr));
        return count;
    }

}