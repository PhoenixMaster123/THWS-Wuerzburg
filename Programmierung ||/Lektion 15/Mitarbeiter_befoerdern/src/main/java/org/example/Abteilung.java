package org.example;

import java.util.ArrayList;
import java.util.List;

public class Abteilung
{
            Abteilungsleiter abteilungsleiter;

            List<Angestellter> list = new ArrayList<>();

            Abteilung(Abteilungsleiter abteilungsleiter, List<Angestellter> list)
            {
                this.abteilungsleiter = abteilungsleiter;
                this.list = list;
            }

}
