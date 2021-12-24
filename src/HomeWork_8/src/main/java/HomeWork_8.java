import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Konstantin Babenko
 * @create 23.12.2021
 */

public class HomeWork_8 {

    public static void main(String[] args) throws IOException {

        /*. ДЗ-7
        Реализовать вывод погоды на следующие 5 дней в формате
        | В городе CITY на дату DATE ожидается WEATHER_TEXT, температура - TEMPERATURE |
        где CITY, DATE, WEATHER_TEXT и TEMPERATURE - уникальные значения для каждого дня.
            ДЗ-8
        1. Добавить поддержку SQLite в проект.
        2. Создать класс-репозиторий, отвечающий за взаимодействие с базой данных.
        3. Организовать запись данных в базу при каждом успешном API запросе.
           Формат - String city, String localDate, String weatherText, Double temperature.
        4. Организовать чтение из базы всех данных по пункту меню (требует переработки меню)
        5. Учесть, что соединение всегда нужно закрывать
         */
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Для получения прогноза на 5 дней, введите название города -->> ");
//        String city = sc.next();

        String city = "Moscow";

        try {
            DBHandler dbHandler = new DBHandler();
            dbHandler.addWeatherCity(city);
            dbHandler.selectAllWeather();
            System.out.println("----------");
            dbHandler.selectWeatherDate("2021-12-25"); // формат даты гггг-мм-дд
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
