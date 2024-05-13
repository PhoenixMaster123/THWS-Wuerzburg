package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        try {
            splitStudiengaenge("MatrNr.txt");
        }
        catch (MatrikelNummerException | IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void splitStudiengaenge(String dateiname) throws IOException, MatrikelNummerException
    {
        try(BufferedReader br = new BufferedReader(new FileReader(dateiname));
            BufferedWriter winf = new BufferedWriter(new FileWriter("WInfNr.txt"));
            BufferedWriter inf = new BufferedWriter(new FileWriter("InfNr.txt"));
            BufferedWriter eco = new BufferedWriter(new FileWriter("ECNr.txt"));)
        {
            do
            {
                String line = br.readLine();
                if (line == null) break;

                if (line.compareTo("5000000") >= 0 && line.compareTo("5099999") <= 0)
                {
                    winf.write(line);
                    winf.newLine();
                }
                else if(line.compareTo("5100000") >= 0 && line.compareTo("5199999") <= 0)
                {
                    inf.write(line);
                    inf.newLine();
                }
                else if (line.compareTo("6100000") >= 0 && line.compareTo("6199999") <= 0)
                {
                    eco.write(line);
                    eco.newLine();
                }
                else
                {
                    throw new MatrikelNummerException("Matrikelnummer is not found " + line);
                }
            }
            while(true);
        }
    }
}
