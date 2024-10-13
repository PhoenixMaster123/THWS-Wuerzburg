package _02_Listen_Stacks_Queues.Übung_02b;

import java.io.*;

public class SmartArray {

    private Candle[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.size = 0;
        this.capacity = 1;
        this.data = new Candle[capacity];
    }
    public Candle get(int index) {
        return this.data[index];
    }
    public int size() {
        return this.size;
    }
    public void add(Candle element) {
        if(this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        Candle[] newArray = new Candle[this.data.length * 2];
        this.capacity = newArray.length;
        for (int index = 0; index < this.data.length; index++) {
            newArray[index] = this.data[index];
        }
        this.data = newArray;
    }

    public Candle getLast() {
        if(size == 0) {
            return null;
        }
        return this.data[size - 1];
    }
    public int search(Candle element) {
        for (int index = 0; index < this.data.length; index++) {
            if(this.data[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }
    public void loadFile(String fname) {
        int counter = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fname))) {
            String line;

            while((line = br.readLine()) != null) {
                if(counter == 0) {
                    counter++;
                    continue;
                }
                String[] tokens = line.split("\t");
                String timestamp = tokens[0];
                double open = Double.parseDouble(tokens[1]);
                double high = Double.parseDouble(tokens[2]);
                double low = Double.parseDouble(tokens[3]);
                double close = Double.parseDouble(tokens[4]);
                int volume = Integer.parseInt(tokens[5]);

                Candle candle = new Candle(timestamp,open,low,high,close,volume);
                this.add(candle);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

