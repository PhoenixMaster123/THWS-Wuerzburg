package summary.IO_Streams.Byte_Streams;

import java.io.*;

public class Reader {

    public void readFromAFileByBytes() {
        try(FileInputStream fis = new FileInputStream("file.txt")) {
            int i;
            while((i = fis.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromAFileByBytesWithBuffer() {
        try(FileInputStream fis = new FileInputStream("file.txt")) {
            byte[] buffer = new byte[10];
            int i;
            while((i = fis.read(buffer)) != -1) {
                for(int j = 0; j < i; j++) {
                    System.out.print((char)buffer[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromAFileByBytesWithBufferAndOffset() {
        try(FileInputStream fis = new FileInputStream("file.txt")) {
            byte[] buffer = new byte[10];
            int i;
            while((i = fis.read(buffer, 0, 5)) != -1) {
                for(int j = 0; j < i; j++) {
                    System.out.print((char)buffer[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void readAndWriteFromFile() {
        try(ByteArrayInputStream bais = new ByteArrayInputStream("Hello World".getBytes());
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int i;
            while((i = bais.read()) != -1) {
                baos.writeTo(new FileOutputStream("file.txt"));
            }
            System.out.println(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();

        reader.readAndWriteFromFile();
    }


}
