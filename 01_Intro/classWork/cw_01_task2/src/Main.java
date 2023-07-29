// Курс: Исключения в программировании и их обработка
// Урок 1. Обработка ошибок в программировании
// Семинар

// Задание #2
// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив и возвращающий сумму элементов.
// Ограничения:
// - метод работает только с квалратными массивами
// - в каждой ячейке может быть только 0 или 1


public class Main
{
    public static void main(String[] args)
    {
        int[][] arr2Da =
                {
                        {0,0,0},
                        {0,0,1,0},
                        {0,1,0},
                        {1,0,0,0},
                };
        int[][] arr2Db =
                {
                        {0,0,0,1},
                        {0,5,1,0},
                        {0,1,3,0},
                        {1,0,0,0},
                };
        int[][] arr2Dc =
                {
                        {0,0,0,1},
                        {0,0,1,0},
                        {0,1,0,0},
                };
        int[][] arr2Dd =
                {
                        {0,0,0,1},
                        {0,0,1,0},
                        {0,1,0,0},
                        {1,0,0,0},
                };

        try
        {
            System.out.printf("sum: %d", sum2DArrayBinary(arr2Da));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        try
        {
            System.out.printf("sum: %d", sum2DArrayBinary(arr2Db));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        try
        {
            System.out.printf("sum: %d", sum2DArrayBinary(arr2Dc));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        try
        {
            System.out.printf("sum: %d", sum2DArrayBinary(arr2Dd));
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    public static int sum2DArrayBinary(int[][] array2DBinary)
    {
        int sum = 0;
        for (int[] row : array2DBinary)
        {
            if (row.length == array2DBinary.length)
            {
                for (int item : row)
                {
                    if (item == 0 || item == 1)
                        sum += item;
                    else
                        throw new RuntimeException("Array contains digits among 0 and 1");
                }
            }
            else
                throw new RuntimeException("2D array is not quadratic");
        }
        return sum;
    }

}