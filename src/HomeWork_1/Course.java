package HomeWork_1;

/**
 * @author Konstantin Babenko
 * @create 26.11.2021
 * <p>
 * Создание полосы препятствий
 */

public class Course {

    private String[] obstacle; //    массив препятствий;
    public Team team;

    public Course() {
        obstacle = new String[4];
        obstacle[0] = "barrier";
        obstacle[1] = "run";
        obstacle[2] = "sand";
        obstacle[3] = "swim";
    }

    //метод, который будет просить команду пройти всю полосу.
    public void doit(Team team) {
        System.out.println("Команда " + team + " просим пройти на старт полосы препятсвий.");
    }

    // информация о составе полосы препятствий
    public void courseInfo() {
        System.out.print("Полоса препятсвий состит из: ");
//        for (int i = 0; i < obstacle.length; i++) {
//            System.out.print(obstacle[i] + ", ");
//        }
        for (String obstacle : obstacle) {
            System.out.print(obstacle + ", ");
        }
        System.out.println();
    }

}


