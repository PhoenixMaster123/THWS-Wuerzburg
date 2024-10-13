package _02_Listen_Stacks_Queues.Übung_02a;

public class SmartArray {

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.size = 0;
        this.capacity = 1;
        this.data = new int[capacity];
    }
    public int get(int index) {
        return this.data[index];
    }
    public int size() {
        return this.size;
    }
    public void add(int element) {
        if(this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        int[] newArray = new int[this.data.length * 2];
        this.capacity = newArray.length;
        for (int index = 0; index < this.data.length; index++) {
            newArray[index] = this.data[index];
        }
        this.data = newArray;
    }

    public int getLast() {
        return this.data[size - 1];
    }
   public int search(int element) {
       for (int index = 0; index < this.data.length; index++) {
           if(this.data[index] == element) {
               return index;
           }
       }
       return -1;
   }

}
