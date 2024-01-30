public class Main {
    public static void main(String[] args) {
        HttpAnfrage httpAnfrage = new HttpAnfrage("GET", "http://www.google.de/index.html");
        httpAnfrage.addHeader("Content-Type", "text/html");

        System.out.println(httpAnfrage.toString());
    }
}
