public class MyArraySizeException extends RuntimeException
{
    public MyArraySizeException()
    {
        super("Array size mismatch");
    }

    public MyArraySizeException(String cause)
    {
        super(String.format("Array size mismatch %s", cause));
    }

}
