// Курс: Исключения в программировании и их обработка
// Урок 1. Обработка ошибок в программировании
// Семинар

// Задание #0
// Реализуйте метод, принимающий в качестве аргумента целочисленный массивю.
// Если длина массива меньше некаторого заданного минимума, метод возвращает -1 в качестве ошибки, иначе - длину массива

public class Main
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        int minimumLength = 2;
        System.out.printf("array length: %d", getLength(arr,minimumLength));
    }

    public static int getLength(int[] array, int minLength)
    {
        return array.length < minLength ? -1 : array.length;
    }
}