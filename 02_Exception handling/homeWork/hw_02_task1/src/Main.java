// Курс: Исключения в программировании и их обработка
// Урок 2: Исключения и их обработка
// Домашняя работа

// Задание #1
// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(GetConsoleInputFloat("Please enter float value"));
    }

    public static float GetConsoleInputFloat(String requestText)
    {
        Scanner consoleInput = new Scanner(System.in);
        System.out.println(requestText);
        while (!consoleInput.hasNextFloat())
        {
            System.out.printf("Entered value is not float type. %s\n", requestText);
            consoleInput.next();
        }
        return consoleInput.nextFloat();
    }
}