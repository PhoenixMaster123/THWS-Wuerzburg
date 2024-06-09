public class Square implements Shape
{
    double value;
    public Square(double value)
    {
        this.value = value;
    }
    @Override
    public double calculateArea()
    {
        return Math.pow(value, 2);
    }
}
