package HomeWork_2;

/**
 * @author Konstantin Babenko
 * @create 04.12.2021
 */

public class HomeWork_2 {


    public static void main(String[] args) {

        // создаем тестовые массивы для проверок
        String[][] arrayNull = new String[4][4]; // пустой массив (null)
        String[][] correctArr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrectArr_1 = { // мало строк
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrectArr_2 = {
                {"10", "20", "30", "40"},
                {"10", "20", "3o", "40"}, // здесь ошибка 0 и О (цифра-буква)
                {"10", "20", "30", "40"},
                {"10", "20", "30", "40"}
        };
        String[][] incorrectArr_3 = {
                {"1", "2", "3", "4", "5"}, // много столбцов
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        /*
        3. В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета.
         */
        try {
//            System.out.println("arrayNull");          // ошибка преобразования
//            checkArray(arrayNull);                    // ошибка преобразования
            System.out.println("correctArr");
            checkArray(correctArr);
//            System.out.println("incorrectArr_1");       // ошибка размера
//            checkArray(incorrectArr_1);                 // ошибка размера
            System.out.println("incorrectArr_2");       // ошибка преобразования
            checkArray(incorrectArr_2);                 // ошибка преобразования
            System.out.println("incorrectArr_3");         // ошибка размера
            checkArray(incorrectArr_3);                   // ошибка размера
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException - Не правильный размер массива");
            System.out.println(e.getLocalizedMessage());
//            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException - Не удается преобразование строки в число");
            System.out.println(e.getLocalizedMessage());
        } finally {
            System.out.println("***********");
        }
        System.out.println("Домашнее задание 2 выпонено.");
    }


    /*
    1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
    или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
    в какой именно ячейке лежат неверные данные.
    */
    public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) throw new MyArraySizeException("Неверное количество строк");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" +
                        " строке", i));
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(String.format("Сумма элементов массива = %d", sum));
    }

    // для проверки размера массива
    // создаем свое исключение MyArraySizeException нследником от Exception
    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    // для проверки возможности преобразования строки в целое число
    // создаем свое исключение MyArrayDataException нследником от NumberFormatException
    public static class MyArrayDataException extends NumberFormatException {
        MyArrayDataException(int row, int col) {
            super(String.format("Неправильные данные в %d строке, %d столбце", row, col));
        }
    }

}
