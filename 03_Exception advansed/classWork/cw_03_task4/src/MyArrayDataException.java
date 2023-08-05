public class MyArrayDataException extends NumberFormatException
{
    public MyArrayDataException()
    {
        super("My array data exception");
    }

    public MyArrayDataException(int row, int column)
    {
        super(String.format("Element (%d,%d) contains not a number value", row, column));
    }

}
