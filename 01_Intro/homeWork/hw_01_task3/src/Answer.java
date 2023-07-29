public class Answer
{
    public int[] divArrays(int[] a, int[] b)
    {
        // Введите свое решение ниже
        if (a.length == b.length)
        {
            int[] c = new  int[a.length];
            for (int i = 0; i < c.length; i++)
            {
                if (b[i] != 0)
                {
                    c[i] = a[i]/b[i];
                }
                else
                {
                    throw new RuntimeException();
                }
            }
            return c;
        }
        return  new int[1];
    }
}
