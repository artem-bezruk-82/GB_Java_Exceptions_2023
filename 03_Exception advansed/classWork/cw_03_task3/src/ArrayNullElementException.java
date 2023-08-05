public class ArrayNullElementException extends NullPointerException
{
    public ArrayNullElementException()
    {
        super("array element is null");
    }

    public ArrayNullElementException(int index)
    {
        super(String.format("array element %d is null", index));
    }
}
