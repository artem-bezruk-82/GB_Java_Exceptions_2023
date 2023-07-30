// Курс: Исключения в программировании и их обработка
// Урок 2: Исключения и их обработка
// Домашняя работа

// Задание #4
// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(getConsoleInput("Please enter text"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static String getConsoleInput(String prompt) throws Exception
    {
        System.out.println(prompt);
        Scanner consoleInput = new Scanner(System.in);
        String consoleInputStr = consoleInput.nextLine();
        if (consoleInputStr.isEmpty())
            throw new Exception("Empty strings are not allowed");

        return consoleInputStr;
    }
}