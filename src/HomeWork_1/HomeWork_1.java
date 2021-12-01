package HomeWork_1;

/**
 * @author Konstantin Babenko
 * @create 26.11.2021
 * <p>
 * Домашняя работа 1
 */

public class HomeWork_1 {

    public static void main(String[] args) {

        Course c = new Course();
        Team team = new Team("Dream");
        System.out.println();

        System.out.println("----------");
        c.doit(team);
        c.courseInfo();
        System.out.println("----------");

        // имитируем прохождение полосы препятствий
        team.users[3].setPassed(true);
        team.users[2].setPassed(true);

        team.getInfoPassedUsers();
        System.out.println("----------");
        team.getInfoTeams();
    }

}
