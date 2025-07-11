package summary.IO_Streams.Object_Streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Reader {
    public void readObjectFromAFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.obj"))) {
            Person person = (Person) ois.readObject();
            System.out.println("Object read from file: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
