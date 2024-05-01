package org.example;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDoubler extends OutputStream
{
    private final OutputStream outputStream1;
    private final OutputStream outputStream2;

    public OutputStreamDoubler(OutputStream outputStream1, OutputStream outputStream2)
    {
        this.outputStream1 = outputStream1;
        this.outputStream2 = outputStream2;
    }
    public void close() throws IOException
    {
        closeMethod();
    }
    public void write(int b) throws IOException
    {
        writeMethod(b);
    }
    private void closeMethod() throws IOException {
        IOException exception = null;
        try {
            outputStream1.close();
            outputStream2.close();
        } catch (IOException e) {
            exception = e;
            System.err.println("Error occurred while writing to outputStream(s):");
            e.printStackTrace();
        }
        if (exception != null) {
            throw exception;
        }
    }
    private void writeMethod(int b) throws IOException {
        IOException exception = null;
        try {
            outputStream1.write(b);
            outputStream2.write(b);
        } catch (IOException e) {
            exception = e;
            System.err.println("Error occurred while writing to outputStream(s):");
            e.printStackTrace();
        }

        if (exception != null) {
            throw exception;
        }
    }
}
