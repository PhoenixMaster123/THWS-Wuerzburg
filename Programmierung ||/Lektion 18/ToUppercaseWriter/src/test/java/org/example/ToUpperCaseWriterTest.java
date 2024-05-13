package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToUpperCaseWriterTest
{

    //ToUpperCaseWriter writer;
    //ByteArrayOutputStream baos;

   /* @BeforeEach
    public void prepareTest()
    {

        baos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(baos);
        writer = new ToUpperCaseWriter(osw);
    }
    */

    @Test
    public void writeCharTest()
    {
            writeFunktion('a',"A");
    }

    @Test
    public void writeCharTestWithNonChar()
    {
            writeFunktion('1',"1");
    }
    @Test
    public void ACIITestBuchstaben()
    {
        for (int i = 'a'; i <= 'z'; i++)
        {
            writeFunktion((char) i, String.valueOf((char) (i - 32)));
           // writeFunktion((char) i, String.valueOf((char) (i)).toUpperCase());
        }
    }
    @Test
    public void ACIITestZeichnen()
    {
        for (int i = 0; i <= 128; i++)
        {
            if( (i >= 'a' &&  i <= 'z') || (i >= 'A' && i <= 'Z'))
            {
                continue;
            }
            else
            {
                writeFunktion((char) i, String.valueOf((char) i));
            }
        }
    }

    private void writeFunktion(char lowerCase, String expectedOutput){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            ToUpperCaseWriter writer = new ToUpperCaseWriter(osw))
        {
            writer.write(lowerCase);
            writer.flush();
            String toUpperCase = baos.toString();
            assertEquals(toUpperCase, expectedOutput);
            baos.reset();
        }
        catch (IOException e)
        {
            e.getStackTrace();
        }

    }

   /*
   @AfterEach
    public void cleanUp()
    {
        try
        {

            writer.close();
        }  
        catch (IOException e) 
        {
            fail("IOException" + e.getMessage());
        }
    }
    */
}
