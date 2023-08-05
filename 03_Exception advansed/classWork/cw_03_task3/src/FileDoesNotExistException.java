import java.io.FileNotFoundException;

public class FileDoesNotExistException extends FileNotFoundException
{
    public FileDoesNotExistException()
    {
        super("File does not exist");
    }

    public FileDoesNotExistException(String filePath)
    {
        super(String.format("File [%s] does not exist", filePath));
    }

}
