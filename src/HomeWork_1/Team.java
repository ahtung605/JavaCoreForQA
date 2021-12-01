package HomeWork_1;

/**
 * @author Konstantin Babenko
 * @create 26.11.2021
 * <p>
 * Создание команды
 */

public class Team {

    private String teamName; // название команды
    public Users[] users; // команда из 4 участников (массив)

    public Team(String teamName) {
        this.teamName = teamName;
        users = new Users[4];
        users[0] = new Users("Игорь", 18);
        users[1] = new Users("Петя", 20);
        users[2] = new Users("Вася", 16);
        users[3] = new Users("Даша", 21);
    }


    // Информация о членах команды, прошедших дистанцию
    public void getInfoPassedUsers() {
        int count = 0; // вспомогательный счетчик
        System.out.println("Участники команды " + teamName + " прошедшие дистанцию: ");
        for (int i = 0; i < users.length; i++) {
            if (users[i].isPassed()) {
                System.out.println(users[i].getName() + " ");
                count += 1;
            }
        }
        System.out.println(((count == 0) ? "К сожалению дистанцию никто не прошел." : "Итого в команде " + teamName + " дистанцию прошло участников: " + count + "."));
    }


     // Информация о составе команды
    public void getInfoTeams() {
        System.out.println("Информация о составе команды " + teamName + ":");
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getUsersInfo());
        }
    }

    // переопределяем toString для приведения класса к строке
    @Override
    public String toString() {
        String tmp = "";
        for (int i = 0; i < users.length; i++) {
            tmp += users[i].getName() + ", ";
        }
        return teamName + " (" + tmp + ")";
    }

}
