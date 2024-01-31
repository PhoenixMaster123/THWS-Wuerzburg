public class ISBN
{
    public boolean validateISBN(String isbn) {
        char[] arr = isbn.toCharArray();
        double result = 0;
        int counter = 1;
        if (arr.length == 13) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    result += counter * ((int) (arr[i] - 48));
                    counter++;
                }
            }
        }
            if (result % 11 == 0) {
                return true;
            }
            return false;

    }
}



