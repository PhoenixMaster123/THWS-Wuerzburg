package org.example;

public class Main {
    public static void main(String[] args) {

        Mensch mensch = new Mensch();
        System.out.println("Gefahrsituationen Mensch:");
        System.out.println(mensch.entscheide(Gefahrensituationen.GEFAHR_LINKS));
        System.out.println(mensch.entscheide(Gefahrensituationen.GEFAHR_RECHTS));
        System.out.println(mensch.entscheide(Gefahrensituationen.GEFAHR_VORNE));

        System.out.println();

        Roboter roboter = new Roboter();
        System.out.println("Gefahrsituationen Roboter:");
        System.out.println(roboter.entscheide(Gefahrensituationen.GEFAHR_LINKS));
        System.out.println(roboter.entscheide(Gefahrensituationen.GEFAHR_RECHTS));
        System.out.println(roboter.entscheide(Gefahrensituationen.GEFAHR_VORNE));

        System.out.println();

        Cyborg cyborg = new Cyborg(mensch,roboter);
        System.out.println("Gefahrsituationen Cyborg:");

        Gefahrensituationen gefahrensituation1 = Gefahrensituationen.GEFAHR_LINKS;
        Gefahrensituationen gefahrensituation2 = Gefahrensituationen.GEFAHR_RECHTS;
        Gefahrensituationen gefahrensituation3 = Gefahrensituationen.GEFAHR_VORNE;

        System.out.println(cyborg.entscheide(gefahrensituation1));
        System.out.println(cyborg.entscheide(gefahrensituation2));
        System.out.println(cyborg.entscheide(gefahrensituation3));

    }
}