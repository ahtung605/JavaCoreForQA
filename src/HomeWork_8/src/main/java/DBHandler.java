import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * @author Konstantin Babenko
 * @create 23.12.2021
 */

public class DBHandler {

    private final String PATH_TO_DB = "jdbc:sqlite:src/main/resources/weather.db";
    private Connection connection;

    public DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }

    public void addWeatherCity(String cityName) throws IOException {
        String[] arr = new String[6]; // временный массив
        WeatherResponse.sendTempRequest(WeatherResponse.sendCityIdRequest(cityName));
        // файл для чтения
        File csvFileReader = new File("src/main/resources/HM8-rw.csv");

        int count = 0; // количество строк
        try (BufferedReader bufferedOutStr = new BufferedReader(new FileReader(csvFileReader))) {
            while (bufferedOutStr.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(count);

        try (BufferedReader bufferedOutStr = new BufferedReader(new FileReader(csvFileReader))) {
            for (int i = 0; i < count; i++) {
                arr = bufferedOutStr.readLine().split(";");
                try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                        "INSERT INTO city ('daterequest', 'cityid', 'cityname', 'localdate', 'wethertext', 'temperature') VALUES (?, ?, ?, ?, ?, ?)"
                )) {
                    preparedStatement.setObject(1, arr[0]);
                    preparedStatement.setObject(2, arr[1]); // "294021"
                    preparedStatement.setObject(3, arr[2]); // "Moscow"
                    preparedStatement.setObject(4, arr[3]);
                    preparedStatement.setObject(5, arr[4]);
                    preparedStatement.setObject(6, Double.parseDouble(arr[5]));
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectAllWeather() {

        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
            while (resultSet.next()) {
//                resultSet.getString("daterequest"),
//                        resultSet.getString("cityid"),
//                        resultSet.getString("cityname"),
//                        resultSet.getString("localdate"),
//                        resultSet.getString("wethertext"),
//                        resultSet.getString("temperature");
                System.out.println("В городе " + resultSet.getString("cityname") + " прогноз погоды на "
                        + resultSet.getString("localdate") + ": " + resultSet.getString("wethertext")
                        + ", теммпература " + resultSet.getString("temperature"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectWeatherDate(String date) {

        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city WHERE localdate = ' " + date +"'");
            while (resultSet.next()) {
//                resultSet.getString("daterequest"),
//                        resultSet.getString("cityid"),
//                        resultSet.getString("cityname"),
//                        resultSet.getString("localdate"),
//                        resultSet.getString("wethertext"),
//                        resultSet.getString("temperature");
                System.out.println("В городе " + resultSet.getString("cityname") + " на "
                        + resultSet.getString("localdate") + " прогноз погоды (от " + resultSet.getString("daterequest") + "): " + resultSet.getString("wethertext")
                        + ", теммпература " + resultSet.getString("temperature"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
