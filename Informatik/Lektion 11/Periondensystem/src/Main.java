public class Main {
    public static void main(String[] args) {

        Elementen[][] ps = new Elementen[7][]; // 7 Spalten [] keine Ahnung wie viel Elementen.
        ps[0] =  new Elementen[2];
        ps[1] = new Elementen[8];
        ps[2] = new Elementen[8];
        ps[3] = new Elementen[18];
        ps[4] = new Elementen[18];
        ps[5] = new Elementen[18];
        ps[6] = new Elementen[18];

        ps[0][0] = new Elementen("Hydrogen", "H", 1, "1");
        ps[0][1] = new Elementen("Helium", "He", 2, "8");
        ps[1][0] = new Elementen("Lithium", "Li", 3, "1");
        ps[1][1] = new Elementen("Beryllium", "Be", 4,"2");
        ps[1][2] = new Elementen("Bor", "B",5,"3");
        ps[1][3] = new Elementen("Carbon", "C", 6, "4");
        ps[1][4] = new Elementen("Nitrogen", "N", 7, "5");
        ps[1][5] = new Elementen("Oxygen", "O", 8, "6");
        ps[1][6] = new Elementen("Fluorine", "F", 9, "7");
        ps[1][7] = new Elementen("Neon","Ne",10, "3");



        for (int i = 0; i < ps.length; i++) {

            for (int j = 0; j < ps[i].length; j++)
            {

                System.out.print(ps[i][j] + " ");
            }
            System.out.println();
        }
    }
}