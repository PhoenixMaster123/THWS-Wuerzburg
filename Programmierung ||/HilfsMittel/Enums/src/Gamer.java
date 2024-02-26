public class Gamer
{
    private int score;
    private Schwierigkeit difficulty;

    public Gamer()
    {
        this.score = 0;
        this.difficulty = Schwierigkeit.LEICHT;
    }

    public Schwierigkeit getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }
}
