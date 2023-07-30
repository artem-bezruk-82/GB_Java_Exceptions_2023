// Курс: Исключения в программировании и их обработка
// Урок 2: Исключения и их обработка
// Семинар

// Задание #1
// Посмотрите на этот код. Все ли с ним хорошо? Если нет, то скорректируйте его и обоснуйте свое решение.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        exampleBad();
        exampleGood();

    }

    public static void exampleBad()
    {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Please enter index of element you are going to change");
        int index = scanner.nextInt();
        try
        {
            arr[index] = 1;
        }
        catch (Exception e)
        {
            System.out.println("index is out of array bounds");
        }
    }

    public static void exampleGood()
    {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Please enter index of element you are going to change");

        try
        {
            int index = scanner.nextInt();
            arr[index] = 1;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Only digits are supported");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("index is out of array bounds");
        }
        System.out.println("end");
    }
}