import java.io.IOException;
import java.util.Scanner;

/**
 * @author Konstantin Babenko
 * @create 18.12.2021
 */

public class HomeWork_7 {

    public static void main(String[] args) throws IOException {

        /*.
        Реализовать вывод погоды на следующие 5 дней в формате
        | В городе CITY на дату DATE ожидается WEATHER_TEXT, температура - TEMPERATURE |
        где CITY, DATE, WEATHER_TEXT и TEMPERATURE - уникальные значения для каждого дня.
         */

        Scanner sc = new Scanner(System.in);
        String city;
        System.out.print("Для получения прогноза на 5 дней, введите название города -->> ");
        city = sc.next();
//        String city = "Moscow";
//        System.out.println(WeatherResponse.sendCityIdRequest(city));

        System.out.println("\nВ городе " + city + " ожидается погода: \n");
        System.out.println(WeatherResponse.sendTempRequest(WeatherResponse.sendCityIdRequest(city)));
    }

}
