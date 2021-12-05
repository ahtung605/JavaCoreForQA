package HomeWork_3;

import java.util.ArrayList;

/**
 * @author Konstantin Babenko
 * @create 05.12.2021
 */

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();

    // получить вес коробки с фруктами
    public float getWeight() {
        float weight = 0.0f;
        for (T b : box) {
            weight += b.getWeight();
        }
        return weight;
    }

    // добавление фруктов
    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }

    // сравнение коробок по массе
    public boolean compareBox(Box secondBox) {
        return (this.getWeight() == secondBox.getWeight()); // true or false
    }

    // пересылка фруктов из однй коробки в другую
    public void dropFruitBox(Box<T> secondBox) {
        secondBox.box.addAll(box); // добавляем все элементы
        box.clear(); // очищаем коробку
    }

}
