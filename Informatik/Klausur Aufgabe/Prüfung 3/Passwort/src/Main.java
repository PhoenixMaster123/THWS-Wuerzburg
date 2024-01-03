public class Main {
    public static void main(String[] args) {

        Passwort passwort = new Passwort("Prog1Und2");
        System.out.println("Instanziliesirung: " + passwort.getPasswort());
        System.out.println(passwort.toString());

        boolean aendernErfolgreich =  passwort.pwAendern("Frog1Und3");
        System.out.println("Ändern erfolgreich " + aendernErfolgreich);
        System.out.println("Pwd nach Änderung  " + passwort.getPasswort());
    }
}