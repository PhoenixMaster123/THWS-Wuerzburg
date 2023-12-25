import javax.swing.*;

public class Lotto {
    int value;
    Lotto next;

    public Lotto(int value)
    {
        this.value = value;
    }

    public void add(int value) {

        while (contains(value)) {
            value = generateRandomNumber();
        }
            Lotto newValue = new Lotto(value);

            if (next == null) {
                next = newValue;
            } else {
                Lotto currentValue = next;
                while (currentValue.next != null) {
                    currentValue = currentValue.next;
                }
                currentValue.next = newValue;
            }
        }

    private boolean contains(int value) {
        Lotto current = next;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    private int generateRandomNumber() {
        return (int) (Math.random() * 49 + 6);
    }
}
