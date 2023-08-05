// Курс: Исключения в программировании и их обработка
// Урок 3: Продвинутая работа с исключениями
// Семинар

// Задание #1
// Создайте метод doSomething(), который может быть источником одного из типов checked exceptions
// (тело самого метода прописывать не обязательно).
// Вызовите этот метод из main и обработайте в нем исключение, которое вызвал метод doSomething().


public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start");
        try
        {
            doSomething();
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
        System.out.println("End");
    }

    public static void doSomething() throws Exception
    {
        throw new Exception("Do something exception text");
    }
}