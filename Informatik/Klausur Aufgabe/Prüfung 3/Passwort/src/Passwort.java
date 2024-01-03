public class Passwort {
    private String passwort;

    public Passwort(String passwort)
    {
        if (alsPWgeeignet(passwort))
        {
            this.passwort = passwort;
        }
        else
        {
            this.passwort = null;
        }
    }
    public String getPasswort()
    {
        return this.passwort;
    }
    private boolean alsPWgeeignet(String passwort) {

        int countGross = 0;
        int countKlein = 0;
        int ziffern = 0;

        char[] pass = passwort.toCharArray();


        for (int i = 0; i < pass.length; i++) {
            if (pass[i] >= 'A' && pass[i] <= 'Z') {
                countGross++;
            } else if (pass[i] >= 'a' && pass[i] <= 'z') {
                countKlein++;
            } else if (pass[i] >= '0' && pass[i] <= '9') {
                ziffern++;
            }
        }
        if (pass.length >= 8 && countGross >= 2 && countKlein >= 2 && ziffern >= 2) {
            return true;
        }

        return false;

    }
    public String toString() {
        if (passwort != null) {
            char[] pass = passwort.toCharArray();
            for (int i = 0; i < pass.length; i++) {
                pass[i] = '*';
            }
            return String.valueOf(pass);

        }
        return "Kein gueltiges Passwort!";
    }
    public boolean pwAendern (String neuesPassword) {
        if (this.passwort == null || neuesPassword == null)
        {
            return false;
        }
        char[] neuesPwd = neuesPassword.toCharArray();
        char[] pwdAktuell = this.passwort.toCharArray();

        if (neuesPwd[0] != pwdAktuell[0]
                && neuesPwd[neuesPwd.length - 1] != pwdAktuell[pwdAktuell.length - 1]
                && alsPWgeeignet(neuesPassword))
        {
            this.passwort = neuesPassword;
            return true;
        }
        return false;
    }
    }

