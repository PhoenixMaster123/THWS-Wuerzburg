public class Main {
    public static void main(String[] args) {

        int caseCounter1 = 0;
        int caseCounter2 = 0;

        do {
            int[] schubladen = {0, 0 , 0};

            int zufall1 = (int) (Math.random() * 2);

            if(zufall1 == 1)
            {
                int zufall2 = (int) (Math.random() * 3);
                schubladen[zufall2]++;
            }
            if(schubladen[0] == 0 && schubladen[1] == 0)
            {
                caseCounter1++;

                if(schubladen[2] == 1)
                {
                    caseCounter2++;
                }
            }
        }while (caseCounter1 < 10000);

        System.out.println(caseCounter1);
        System.out.println(caseCounter2);
        System.out.println("Die Wahrscheinlichkeit ist: " + caseCounter2/10000.0);
    }
}