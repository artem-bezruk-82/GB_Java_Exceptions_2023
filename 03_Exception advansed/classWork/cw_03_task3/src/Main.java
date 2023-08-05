// Курс: Исключения в программировании и их обработка
// Урок 3: Продвинутая работа с исключениями
// Семинар

// Задание #3
// 1. Создайте класс исключения, который будет выбрасываться при делении на 0.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
//2. Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа.
// Исключение должно отображать понятное для пользователя сообщение об ошибке
//3. Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            int a = 5/0;
        }
        catch (ArithmeticException ae)
        {
            try
            {
                throw new DivByZeroException();
            }
            catch (DivByZeroException dbze)
            {
                System.out.println(dbze.getMessage());
            }
        }

        int i = 0;
        try
        {
            Integer[] arr = {1,2,3, null, 5,6,7};
            for (; i < arr.length; i++)
                arr[i]++;
        }
        catch (NullPointerException npe)
        {
            try
            {
                throw new ArrayNullElementException(i);
            }
            catch (ArrayNullElementException anee)
            {
                System.out.println(anee.getMessage());
            }
        }

        String path = "test.txt";
        try(FileReader fr = new FileReader(path))
        {
            int a = 5;
        }
        catch (FileNotFoundException fnfe)
        {
            try
            {
                throw new FileDoesNotExistException(path);
            }
            catch (FileDoesNotExistException fdnee)
            {
                System.out.println(fdnee.getMessage());
            }

        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }

    }
}