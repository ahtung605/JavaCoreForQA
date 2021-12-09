package HomeWork_4;

import java.util.*;

/**
 * @author Konstantin Babenko
 * @create 08.12.2021
 */

public class HomeWork_4 {

    public static void main(String[] args) {

    /*
    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать, сколько раз встречается каждое слово.
    */
        System.out.println();
        System.out.println("Задача 1.");
        // создаем список слов, в т.ч. повторяющиеся
        String[] wordArr = new String[]{"Создать", "массив", "набор", "слов", "слов", "должны", "встречаться", "вывести",
                "список", "уникальных", "слов", "массив", "слово", "создать", "список"};

        HashMap<String, Integer> wordArrUnic = new HashMap<>();

        for (String word : wordArr) {
            if (wordArrUnic.get(word) == null) {
                wordArrUnic.put(word, 1);
            } else {
                wordArrUnic.put(word, wordArrUnic.get(word) + 1);
            }
        }

        // выводим начальный список (для наглядности)
        System.out.println("Начальный список:");
        for (int i = 0; i < wordArr.length; i++) {
            System.out.print(wordArr[i] + ", ");
        }
        System.out.println();
        // выводим уникальный список (с частотой упоминания)
        System.out.println("Список уникальных слов в списке (с частотой упоминания): " + "\n" + wordArrUnic);
        System.out.println();

    /*
    2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер
    телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    тогда при запросе такой фамилии должны выводиться все телефоны.
    Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
    через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.
    */

        System.out.println("Задача 2.");
        // создаем книгу
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "11-111");
        phoneBook.add("Иванов", "22-222");
        phoneBook.add("Петров", "33-333");
        phoneBook.add("Сидоров", "44-444");

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров")); // 2 телефона
        System.out.println(phoneBook.get("Сидоров"));
        System.out.println(phoneBook.get("сидоров")); // нет такого

    }

    // внутренний класс для телефонной книги
    private static class PhoneBook {
        private Map<String, List<String>> phoneBookHM = new HashMap<>();
        private List<String> phoneNumberList;

        public void add(String surname, String phone_number) {
            if (phoneBookHM.containsKey(surname)) {
                phoneNumberList = phoneBookHM.get(surname);
                phoneNumberList.add(phone_number);
                phoneBookHM.put(surname, phoneNumberList);
            } else {
                phoneNumberList = new ArrayList<>();
                phoneNumberList.add(phone_number);
                phoneBookHM.put(surname, phoneNumberList);
            }
        }

       public List<String> get(String surname) {
            return phoneBookHM.get(surname);
        }
    }
}
