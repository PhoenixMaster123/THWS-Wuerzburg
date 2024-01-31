public class Door {
    private int number;
    private boolean isOpen;
    public Door(int number, boolean isOpen) {
        this.number = number;
        this.isOpen = isOpen;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    @Override
    public String toString() {
        return isOpen ? "o" : "z";
    }
}