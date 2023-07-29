// Курс: Исключения в программировании и их обработка
// Урок 1. Обработка ошибок в программировании
// Семинар

// Задание #4
// Реализовать метод, принимающий в качестве аргумента целочисленный одномерный массив.
// Метод должен проверит каждый элемент на равенство null.
// Если в какой-то ячейке встречается null - оповестить пользователя об этом.
// Если null в нескольких ячейках - указать пользоваетлю в каких ячейках был null


public class Main
{
    public static void main(String[] args)
    {
        Integer[] arrA = {1,2,3,4,5};
        Integer[] arrB = {1,2, null,4,5};
        checkArrayConsole(arrA);
        checkArrayConsole(arrB);
    }

    public static void checkArrayConsole(Integer[] array)
    {
        try
        {
            if (!checkArray(array))
                System.out.println("There are no null values");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkArray(Integer[] array)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null)
                sb.append(String.format("%d,",i));
        }
        if (sb.length() > 0)
            throw new RuntimeException(String.format("null appeared in following positions: {%s}",sb));

        return false;
    }
}