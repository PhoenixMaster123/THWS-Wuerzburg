package summary.IO_Streams.Charachter_Streams;

import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public void readFromATxtFile() {
        try(FileReader isr = new FileReader("file.txt")) {
            int i;
            while((i = isr.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
