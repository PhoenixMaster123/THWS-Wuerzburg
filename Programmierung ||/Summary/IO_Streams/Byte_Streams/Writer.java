package summary.IO_Streams.Byte_Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    public void writeToAFileByBytes() {
        try(FileInputStream fis = new FileInputStream("file.txt");
            FileOutputStream fos = new FileOutputStream("file.txt")) {

            int i;
            while((i = fis.read()) != -1) {
                fos.write(i);
                fos.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
