package summary.IO_Streams.Charachter_Streams;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void writeToATxtFile() {
        try (FileWriter osw = new FileWriter("file.txt")) {
            osw.write("Hello World");
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readAndWriteToATxtFile() {
        try (FileWriter osw = new FileWriter("file.txt");
             FileReader isr = new FileReader("file.txt")) {

            int i;
            while((i = isr.read()) != -1) {
                osw.write((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeZeilenWeise() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))) {

            bw.write("Hello World");
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
