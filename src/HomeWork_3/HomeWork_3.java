package HomeWork_3;

import java.util.Arrays;

/**
 * @author Konstantin Babenko
 * @create 05.12.2021
 */

public class HomeWork_3 {
    public static void main(String[] args) {

        // 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        System.out.println("Задача 1.\n");
        Integer array1[] = {1, 2, 3, 4, 5, 6, 7};
        String array2[] = {"A", "B", "C"} ;
        swapElementArray(array1,1,4);
        swapElementArray(array2,0,2);

/*
Для хранения фруктов внутри коробки можно использовать ArrayList;
!!!! ArrayList !!!!!!!!  https://javarush.ru/groups/posts/klass-arraylist
 */
        System.out.println("Задача 2.\n");

        // создаем коробки под фрукты
        Box<Apple> appleBox1 = new Box();
        Box<Apple> appleBox2 = new Box();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();

        // наполняем коробки
        appleBox1.addFruit(new Apple(), 3);
        appleBox2.addFruit(new Apple(), 5);
        orangeBox1.addFruit(new Orange(), 3);
        orangeBox2.addFruit(new Orange(), 2);

        // выводим вес коробок
        System.out.println("Вес 1-й коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес 2-й коробки с яблоками: " + appleBox2.getWeight());
        System.out.println("Вес 1-й коробки с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес 2-й коробки с апельсинами: " + orangeBox2.getWeight());
        System.out.println("**********");

        // сравниваем коробки по весу
        System.out.println("1-я коробка яблок равна по весу 1-й коробке апельсинов: " + appleBox1.compareBox(orangeBox1));
        System.out.println("1-я коробка яблок равна по весу 2-й коробке апельсинов: " + appleBox1.compareBox(orangeBox2));
        System.out.println("**********");

        // пересылаем фрукты из 2-й коробки в 1-ю коробку
        appleBox2.dropFruitBox(appleBox1);
        orangeBox2.dropFruitBox(orangeBox1);

        // выводим вес коробок после пересылки
        System.out.println("Пересылаем фрукты из 2-й коробки в 1-ю коробку.");
        System.out.println("Вес 1-й коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес 2-й коробки с яблоками: " + appleBox2.getWeight());
        System.out.println("Вес 1-й коробки с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес 2-й коробки с апельсинами: " + orangeBox2.getWeight());
    }

    // Метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static void swapElementArray(Object[] array, int idx1, int idx2){
        System.out.println("Исходный массив \n"+ Arrays.toString(array));
        Object temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
        System.out.println("Результат замены местами элементов (" + idx1 + ") и (" + idx2 + ") массива \n" + Arrays.toString(array) + "\n***********\n");
    }
}
