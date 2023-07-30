// Курс: Исключения в программировании и их обработка
// Урок 2: Исключения и их обработка
// Домашняя работа

// Задание #2


public class Main
{
    public static void main(String[] args)
    {
        int[] intArray = {1,2,3,4,5,6,7,8,9};
        //int[] intArray = {1,2,3,4};
        try
        {
            int d = 0;
            //int d = 1;
            double caughtRes1 = (double) intArray[8] / d;
            System.out.println("caughtRes1 = " + caughtRes1);
        }
        catch (ArrayIndexOutOfBoundsException | ArithmeticException e )
        {
            System.out.println("Catching exception: " + e);
        }

    }
}