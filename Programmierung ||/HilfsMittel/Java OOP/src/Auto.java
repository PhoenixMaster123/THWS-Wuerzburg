public class Auto extends Fahrzeug
{
    int geschwiendigkeit = 120;

    public void fahren()
    {
        super.fahren();
        System.out.println("Brum Brum");
    }

    @Override
    public int getGeschwiendigkeit() {
        return super.getGeschwiendigkeit();
    }
}
