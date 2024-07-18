package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        Person person = new Person("Kristian", "Popov", 21);
        System.out.println(gibKopie(person));
    }
    public static Person gibKopie(Person p)
    {
        Person person = null;
        try(ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream object = new ObjectOutputStream(out))
        {
            object.writeObject(p);

            byte[] personenBytes = out.toByteArray();

            try(ByteArrayInputStream in = new ByteArrayInputStream(personenBytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(in))
            {
                person = (Person) objectInputStream.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.getStackTrace();
        }
        return person;
    }
}