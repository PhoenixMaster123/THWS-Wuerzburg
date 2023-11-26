import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {

        String seite = "<body id=\"www-wikipedia-org\">"
                + "<div class=\"central-textlogo\">"
                + "<img src=\"http://upload.wikimedia.org/wikipedia/commons/thumb"
                + "/b/bb/Wikipedia_wordmark.svg/174px-Wikipedia_wordmark.svg.png\">"
                + "</div>"
                + "</body>";

        int startIndex = seite.indexOf("<img src=\"");

        if(startIndex != -1)
        {
            startIndex = startIndex + "<img src=\"".length();
            int endIndex = seite.indexOf('\"', startIndex);
            String url = seite.substring(startIndex,endIndex);
            System.out.println(url);

            try {
                URL imageUrl = new URL(url);
                BufferedImage image = ImageIO.read(imageUrl);
                ImageIO.write(image, "png", new File("bild.png"));
                System.out.println("Image saved successfully.");
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
