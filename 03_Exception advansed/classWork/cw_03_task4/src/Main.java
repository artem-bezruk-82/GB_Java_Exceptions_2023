// Курс: Исключения в программировании и их обработка
// Урок 3: Продвинутая работа с исключениями
// Семинар

// Задание #4
// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
// и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).

public class Main
{
    public static void main(String[] args)
    {
        String [][] arr1 =
                {
                        {"1", "2", "3", "4"},
                        {"5", "6", "7", "8"},
                        {"9", "8", "7", "6"},
                        {"1", "2", "3", "4"}
                };
        String [][] arr2 =
                {
                        {"1", "2", "3", "4"},
                        {"5", "m", "7", "8"},
                        {"9", "8", "7", "6"},
                        {"1", "2", "3", "4"}
                };
        String [][] arr3 =
                {
                        {"1", "2", "3", "4"},
                        {"5", "5", "7", "8"},
                        {"9", "8", "7", "6"}
                };
        String [][] arr4 =
                {
                        {"1", "2", "3"},
                        {"5", "6", "7", "8"},
                        {"9", "8"},
                        {"1", "2", "3", "4", "5"}
                };

        test(arr1);
        test(arr2);
        test(arr3);
        test(arr4);
    }

    public static void test(String[][] array2D)
    {
        try
        {
            System.out.printf("sum = %d\n", sumSquareMatrix(array2D, 4));
        }
        catch (MyArraySizeException | MyArrayDataException exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    public static Integer sumSquareMatrix(String[][] matrix, int size) throws MyArraySizeException
    {
        Integer sum = null;
        int rows = get2DArrayLength(matrix,0);
        int cols = get2DArrayLength(matrix,1);
        if (rows == size && cols == size)
        {
            sum = 0;
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    try
                    {
                        sum += Integer.parseInt(matrix[i][j]);
                    }
                    catch (NumberFormatException nfe)
                    {
                        throw new MyArrayDataException(i,j);
                    }
                }
            }
        }
        else
            throw new MyArraySizeException(String.format("Array %dx%d does not fit %dx%d size", rows, cols, size, size));

        return sum;
    }

    public static Integer get2DArrayLength(String[][] array2D, int dimension)
    {
        Integer length = null;
        if (dimension == 0)
            length = array2D.length;

        else if (dimension == 1)
        {
            int cols = array2D[0].length;
            for (String[] row : array2D)
            {
                if (row.length != cols)
                    throw new MyArraySizeException("Jagged arrays are not supported");
            }
            length = cols;
        } else
        {
            throw new RuntimeException("Only 2 dimensions supported. That are 0 and 1");
        }
        return length;
    }
}