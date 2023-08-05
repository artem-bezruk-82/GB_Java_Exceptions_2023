public class Counter implements AutoCloseable
{
    private int counter;
    private boolean closed;

    public Counter()
    {
        closed = false;
    }

    public int getCounter() { return counter; }
    public boolean isClosed() { return closed; }

    public void add() throws Exception
    {
        if (!this.isClosed())
            counter++;
        else
            throw new Exception("Counter has been closed");
    }

    @Override
    public void close()
    {
        closed = true;
    }
}
