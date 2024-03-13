import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{
    Person person;

    @Test
    public void correctTest()
    {
        try {
            person = new Person("Kristian", "Popov","Würzburg");
        }
        catch (RuntimeException e)
        {
            fail();
        }
    }
    @Test
    public void failTest()
    {
        try {
            person = new Person("kristian", "Popov","Würzburg");
            fail("Vorname muss mit große Buchstabe sein");
        }
        catch (RuntimeException e)
        {
            assertTrue(true);
        }
    }

}