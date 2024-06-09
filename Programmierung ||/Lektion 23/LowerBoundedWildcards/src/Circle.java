public class Circle implements Shape
{
    public int value;
    public Circle(int value)
    {
        this.value = value;
    }

    @Override
    public double calculateArea()
    {
        return Math.PI * Math.pow(value,2);
    }
}
