// Курс: Исключения в программировании и их обработка
// Урок 1. Обработка ошибок в программировании
// Семинар

// Задание #1
// Реализовать метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
// Метод ищет в массиве заданное значение и возвращает его индекс.
// - Если длина массива меньшне некоторого заданного значения, метод возвращает -1
// - Если искомый элемент н найден -, метод возвращает -2
// - Если вместо массива пришел null, метод возвращает -3
// Написать метод, реализующий взаимодействие с пользователем.
// Метод запрашивает искомое число у мользователя, вызывает первый метод, обрабатывает возвращаемое значение и
// показывает пользователю читаемый результат

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        findValueConsole(arr);
    }

    public static int getIndex(int[] array, int value, int minArrayLength)
    {
        if (array == null)
            return -3;

        if (minArrayLength < 0)
            return -4;

        if (array.length < minArrayLength)
            return -1;

        Arrays.sort(array);
        int index = Arrays.binarySearch(array, value);
        if (index < 0)
            return -2;

        return index;
    }

    public static void findValueConsole(int[] array)
    {
        int value = getConsoleInputInt("Please enter value");
        int minArrayLength = getConsoleInputInt("Please enter minimum array length");
        int index = getIndex(array, value, minArrayLength);
        switch (index)
        {
            case -1:
                System.out.println("Array length less than minimum");
                break;
            case -2:
                System.out.println("Element does not exist");
                break;
            case -3:
                System.out.println("null reference");
                break;
            case -4:
                System.out.println("Minimum Array Length less than zero");
                break;
            default:
                System.out.printf("value %d has %d index\n", value, index);
                break;
        }
    }

    public static int getConsoleInputInt(String requestText)
    {
        return getConsoleInputInt(requestText, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getConsoleInputInt(String requestText, int startRange, int endRange)
    {
        Scanner consoleInput = new Scanner(System.in);
        int value;
        do
        {
            System.out.println(requestText);
            while (!consoleInput.hasNextInt())
            {
                System.out.printf("Entered value is not integer type. %s\n", requestText);
                consoleInput.next();
            }
            value = consoleInput.nextInt();
            if (value < startRange || value > endRange)
            {
                System.out.printf("Entered value is out of %d...%d range. %s\n", startRange, endRange, requestText);
            }
        } while (value < startRange || value > endRange);
        return value;
    }


}