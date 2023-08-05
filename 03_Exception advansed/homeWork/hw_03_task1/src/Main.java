// Курс: Исключения в программировании и их обработка
// Урок 3: Продвинутая работа с исключениями
// Домашняя работа

// Задание #1
// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество, дата_рождения, номер_телефона, пол
// Форматы данных:
// - фамилия, имя, отчество - строки
// - дата_рождения - строка формата dd.mm.yyyy
// - номер_телефона - целое беззнаковое число без форматирования
// - пол - символ латиницей f или m.
// Критерии:
// - Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
// что он ввел меньше и больше данных, чем требуется.
// - Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
// Можно использовать встроенные типы java и создать свои.
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//- Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
// в него в одну строку должны записаться полученные данные, вида: "Фамилия Имя Отчество, дата_рождения, номер_телефона, пол"

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean end = false;
        while (!end)
        {
            try
            {
                String[] data = getDataConsole();
                String[] fullName = getFullName(data);
                LocalDate birthdayDate = getBirthdayDate(data);
                double phone = getPhone(data);
                char gender = getGender(data);
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%s ", String.join(" ", fullName)));
                sb.append(String.format("%s ", birthdayDate));
                sb.append(String.format("%s ",phone));
                sb.append(gender);
                sb.append("\n");
                writeToFile(sb.toString(), String.format("%s.txt",fullName[0]));
                end = true;
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static String[] getDataConsole()
    {
        System.out.println("Please enter data space separated in following format: " +
                "\"LastName Firstname MiddleName Birthday(dd.mm.yyyy) phone(11 digits) gender('f' or 'm')\"");
        Scanner scanner = new Scanner(System.in);
        String consoleInputString = scanner.nextLine();
        consoleInputString = consoleInputString.replaceAll("\\s+"," ");
        String[] consoleInput = consoleInputString.split(" ");
        if (consoleInput.length < 6)
            throw new IllegalArgumentException("Not enough data entered");

        return consoleInput;
    }

    public static LocalDate getBirthdayDate(String[] input)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (String item : input)
        {
            try
            {

                return LocalDate.parse(item, formatter);
            }
            catch (DateTimeParseException dtpe)
            {
                continue;
            }
        }
        throw new DateTimeParseException("Wrong date format", Arrays.toString(input), 0);
    }

    public static Double getPhone(String[] input)
    {
        Double phone = null;
        for (String item : input)
        {
            try
            {
                phone = Double.parseDouble(item);
                if (phone < 10000000000L || phone > 99999999999L)
                {
                    throw new NumberFormatException("Phone must contain 11 digits");
                }
                break;
            }
            catch (NumberFormatException nfe)
            {
                continue;
            }
        }
        if (phone == null)
        {
            throw new NumberFormatException("Phone must contain digits only");
        }
        return phone;
    }

    public static Character getGender(String[] input)
    {
        for (String item : input)
        {
            if (item.length() == 1)
            {
                if (item.equals("f") || item.equals("m"))
                    return item.charAt(0);
                else
                {
                    throw new IllegalArgumentException("Only 'f' or 'm' characters are allowed to define gender");
                }

            }
        }
        throw new IllegalArgumentException("Only '1 character required to define gender");
    }

    public static String[] getFullName(String[] input)
    {
        ArrayList<String> fullNameList = new ArrayList<>();
        for (String item : input)
        {
         if (item.length() > 1 && item.matches("[a-zA-Z]+"))
             fullNameList.add(item);
        }
        if (fullNameList.size() < 3 )
        {
            throw new IllegalArgumentException("incorrect name");
        }
        return fullNameList.toArray(new String[fullNameList.size()]);
    }

    public static void writeToFile(String text, String filePath) throws IOException
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true)))
        {
            bw.write(text);
            bw.write("\n");
        }
    }
}