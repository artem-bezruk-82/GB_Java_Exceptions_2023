// Курс: Исключения в программировании и их обработка
// Урок 2: Исключения и их обработка
// Семинар

// Задача #3
// Запишите в файл следующие строки:
// Анна=4 Елена=5 Марина=6 Владимир=? Константин=? Иван=4
// Реализуйте метод, который считывает данные из файла и сохраняет в HashMap.
// В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
// Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
// Записать в тот же файл данные с замененными символами ?.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main
{
    public static void main(String[] args)
    {
        String file = "text.txt";
        String text = "Анна=4\nЕлена=5\nМарина=6\nВладимир=?\nКонстантин=?\nИван=4";
        writeToFile(text, file);
        HashMap<String, String> names = getNamesFromFile(file);
        System.out.println(names);
        correctData(names);
        System.out.println(names);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : names.entrySet())
            sb.append(String.format("%s=%s\n",entry.getKey(),entry.getValue()));

        writeToFile(sb.toString(),file);
    }

    public static void correctData(HashMap<String, String> names)
    {
        for (Map.Entry<String, String> entry : names.entrySet())
        {
            if (Objects.equals(entry.getValue(), "?"))
            {
                entry.setValue(String.format("%s",entry.getKey().length()));
            }
            else
            {
                try
                {
                    Integer.parseInt(entry.getValue());
                }
                catch (NumberFormatException nfe)
                {
                    System.out.printf("Not a number in %s name\n", entry.getKey());
                }
            }
        }
    }

    public static HashMap<String, String> getNamesFromFile(String filePath)
    {
        HashMap<String, String> names = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String s;
            while((s = br.readLine()) != null)
            {
                try
                {
                    String[] record = s.split("=");
                    names.put(record[0],record[1]);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return names;
    }

    public static void writeToFile(String text, String filePath)
    {
        try(FileWriter writer = new FileWriter(filePath, false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}