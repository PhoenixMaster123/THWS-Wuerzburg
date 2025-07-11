package summary.IO_Streams.Object_Streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    public void writeObjectToAFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.obj"))) {
            Person person = new Person("John", 30, "New York");
            oos.writeObject(person);
            System.out.println("Object written to file: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
