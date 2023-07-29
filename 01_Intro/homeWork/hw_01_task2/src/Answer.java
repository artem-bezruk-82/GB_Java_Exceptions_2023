public class Answer
{
    public int[] subArrays(int[] a, int[] b)
    {
        // Введите свое решение ниже

        if (a.length == b.length)
        {
            int[] c = new int[a.length];
            for (int i = 0; i < c.length; i++)
            {
                c[i] = a[i] - b[i];
            }
            return c;
        }
        return new int[1];
    }
}
