public class Ticker {
    private final char[] nachricht;
    private final int messageSize;

    public Ticker (int size) {
        if (size <= 0) {
            this.messageSize = 200;
        } else {
            this.messageSize = size;
        }

        this.nachricht = new char[this.messageSize];

        for (int i = 0; i < nachricht.length; i++) {
            nachricht[i] = ' ';
        }
    }

    public int getSize () {
        return this.messageSize;
    }

    public void setNachricht(char[] nachricht) {
        int lengthToCopy = Math.min(nachricht.length, this.nachricht.length);
        for (int i = 0; i < lengthToCopy; i++) {
            this.nachricht[i] = nachricht[i];
        }
    }
    public char[] getNachricht() {
        return this.nachricht;
    }

    public void resetNachricht (char zeichen) {
        for (int i = 0; i < this.nachricht.length; i++) {
            nachricht[i] = zeichen;
        }
    }

    public void resetNachricht () {
        resetNachricht('+');
    }

    public void rotateNachricht (int distance) {
        if (distance <= 0 || distance >= this.nachricht.length) {
            return;
        } else {
            char[] temp = new char[distance];
            for (int d = 0; d < this.nachricht.length; d++) {
                int newInd = d - distance;
                if (newInd < 0) {
                    temp[distance + newInd] = this.nachricht[d];
                } else {
                    this.nachricht[newInd] = this.nachricht[d];
                }
            }
            for (int t = 0; t < temp.length; t++) {
                this.nachricht[this.nachricht.length -distance +t] = temp[t];
            }
        }
    }
}