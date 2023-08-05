// Курс: Исключения в программировании и их обработка
// Урок 3: Продвинутая работа с исключениями
// Семинар

// Задание #2
// Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1.
// Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources.
// Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт.
// Подумайте какой тип исключения подойдет лучше всего.

public class Main
{
    public static void main(String[] args)
    {
        try(Counter counter = new Counter())
        {
            counter.add();
            System.out.println(counter.getCounter());
            counter.add();
            System.out.println(counter.getCounter());
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}