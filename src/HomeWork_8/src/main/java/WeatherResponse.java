import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Konstantin Babenko
 * @create 23.12.2021
 */

public class WeatherResponse {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_KEY = "bgyWiwiHKf9dxb7rc3VYfR3dUXYhNafI";
    public static String cityName;
    public static String cityEnglishName;
    public static String cityId;

    public static String sendCityIdRequest(String cityName) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();
        JsonNode cityIdNode = objectMapper
                .readTree(responseJson)
                .at("/0/Key");
        cityId = cityIdNode.asText();
        JsonNode cityEnglishNameNode = objectMapper
                .readTree(responseJson)
                .at("/0/EnglishName");
        cityEnglishName = cityEnglishNameNode.asText();
        return cityId;
    }

    public static String sendTempRequest(String cityId) throws IOException {
        Date date = new Date(); // Установка текущей даты и времени с использованием toString()
        String daterequest = date.toString();
        // собираем УРЛ
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        // формируем запрос
        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        // пролучаем ответ
        Response response = okHttpClient.newCall(request).execute();

        // ответ переводим в строку
        String responseJson = response.body().string();
        System.out.println(responseJson);

        // парсим строку и собираем данные за 5 дней
        String str = ""; // временная строка сдля сброки
        for (int i = 0; i < 5; i++) {
            // день
            JsonNode dayNode = objectMapper
                    .readTree(responseJson)
                    .at("/DailyForecasts/" + i + "/Date");
            String day = dayNode.asText().substring(0, 10);
            // описание дня
            JsonNode textNode = objectMapper
                    .readTree(responseJson)
                    .at("/DailyForecasts/" + i + "/Day/IconPhrase");
            String text = textNode.asText();
            // температура
            JsonNode tempNode = objectMapper
                    .readTree(responseJson)
                    .at("/DailyForecasts/" + i + "/Temperature/Minimum/Value");
            String temp = tempNode.asText();
            // формируем строку
//            str += "на дату " + day + ": " + text + ", Температура " + temp + " С. \n";
            str += daterequest + "; " + cityId + "; " + cityEnglishName + "; " + day + "; " + text + "; " + temp + ";\n";
        }
        // записыавем в файл данные
        File csvFileWrite = new File("src/main/resources/HM8-rw.csv");

        try (PrintWriter writer = new PrintWriter(csvFileWrite)) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

}
