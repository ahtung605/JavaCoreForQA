package HomeWork_1;

/**
 * @author Konstantin Babenko
 * @create 26.11.2021
 * <p>
 * Создание участников
 */

public class Users {

    private String name; // имя
    private int age; // возраст
    private boolean isPassed; // прошел или нет дистанцию (по умолчанию - нет)

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
        isPassed = false;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public String getName() {
        return name;
    }

//    public int getAge() {
//        return age;
//    }

    public boolean isPassed() {
        return isPassed;
    }

    // Строковая информация об участнике
    public String getUsersInfo() {
        return "Участник - " + name + ", возраст - " + age + " лет, полосу препятствий " + ((isPassed) ? " прошел." : "не прошел.");
    }

}
