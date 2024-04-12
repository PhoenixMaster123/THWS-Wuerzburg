public class Main {
    public static void main (String[]  args) {
        Ticker wetter = new Ticker(45);
        wetter.setNachricht("Wettervorhersage: Schnee in WÃ¼rzburg".toCharArray());
        System.out.println(String.valueOf(wetter.getNachricht()));
        wetter.rotateNachricht(14);
        System.out.println(String.valueOf(wetter.getNachricht()));
        wetter.resetNachricht();
        System.out.println(String.valueOf(wetter.getNachricht()));
    }
}