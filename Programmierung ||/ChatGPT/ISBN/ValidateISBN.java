package ChatGPT.ISBN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateISBN {

    public boolean checkISBN(String isbn) throws UngueltigenISBNException {
        char[] isbnArray = isbn.toCharArray();
        int sum = 0;
        int counter = 10;

        if (isbnArray.length != 10) {
            throw new UngueltigenISBNException("Die ISBN muss genau 10 Zeichen lang sein.");
        }
        for (int i = 0; i < isbnArray.length; i++) {
            if (isbnArray[i] != 'X' && (isbnArray[i] < '0' || isbnArray[i] > '9')) {
                throw new UngueltigenISBNException("Die ISBN darf nur Zahlen und den Buchstaben X enthalten.");
            }
            if (isbnArray[i] == 'X') {
                sum += 10;
            } else {
                sum += isbnArray[i] - '0';
                // sum += Character.getNumericValue(isbnArray[i]);
            }
            sum *= counter;
            counter--;
        }
        return sum % 11 == 0;
    }
    public List<String> lesenISBNsAusDatei(String datei) throws UngueltigenISBNException{
        List<String> wrongISBNs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(datei))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!checkISBN(line)) {
                    wrongISBNs.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wrongISBNs;
    }

    public Map<String, List<String>> lesenISBNsAusMehrereDateien(String... dateien) throws UngueltigenISBNException {
       Map<String, List<String>> map = new HashMap<>();

       for(String dateiName : dateien) {
              map.put(dateiName, lesenISBNsAusDatei(dateiName));
       }

       return map;
    }
}
