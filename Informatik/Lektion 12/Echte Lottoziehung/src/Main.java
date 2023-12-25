import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Lotto lotto = new Lotto(49);
        for (int i = 1; i <= 49; i++) {
            int random = (int) (Math.random() * 49 + 6);
            lotto.add(random);
        }

        Lotto current = lotto.next;
        while (current != null)
        {
            System.out.print(" " + current.value);
            current = current.next;
        }

    }
}