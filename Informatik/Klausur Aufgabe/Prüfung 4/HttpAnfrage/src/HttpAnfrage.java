public class HttpAnfrage {
    private String method;
    private String url;
    private String[] headers = new String[20];

    public HttpAnfrage(String method, String url) {
        if (method.equals("POST") || method.equals("GET")) {
            this.method = method;
        } else {
            this.method = "GET";
        }
        this.url = url;
    }

    public boolean addHeader(String name, String wert) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i] == null) {
                headers[i] = name + ": " + wert;
                return true; // Header erfolgreich hinzugefügt
            }
        }
        return false; // Kein Platz mehr für weitere Header
    }

    @Override
    public String toString() {
        String httpRequest = method + " " + url + " HTTP/1.0\r\n";

        for (int i = 0; i < headers.length; i++) {
            if (headers[i] != null) {
                httpRequest += headers[i] + "\r\n";
            }
        }

        httpRequest += "\r\n"; // Leerzeile am Ende der Anfrage
        return httpRequest;
    }
}
