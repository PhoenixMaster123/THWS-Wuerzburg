public class Punkt
{
    int x;
    int y;
    public void verschiebePunkt(int zielX, int zielY) {

        if(zielX < 0 || zielY < 0 || zielX > 1980 || zielY > 1080)
        {
            throw new RuntimeException();
        }
        x = zielX;
        y = zielY;
    }
}
