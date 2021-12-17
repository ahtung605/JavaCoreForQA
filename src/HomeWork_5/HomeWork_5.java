package HomeWork_5;

import java.io.*;
import java.util.Arrays;

/**
 * @author Konstantin Babenko
 * @create 12.12.2021
 */

public class HomeWork_5 {

    public static void main(String[] args) {

        // 1. Реализовать сохранение данных в csv файл;
        System.out.println("Задача 1.");
        // файл для записи
        File csvFileWrite = new File("src/HomeWork_5/HM5-rw.csv");

        // готовим данные для записи
        StringBuilder sb = new StringBuilder();
        sb.append("Value 1");
        sb.append(";");
        sb.append("Value 2");
        sb.append(";");
        sb.append("Value 3");
        sb.append('\n');

        sb.append("100");
        sb.append(";");
        sb.append("200");
        sb.append(";");
        sb.append("123");
        sb.append('\n');

        sb.append("300");
        sb.append(";");
        sb.append("400");
        sb.append(";");
        sb.append("500");
        sb.append('\n');

        // записыавем в файл данные
        try (PrintWriter writer = new PrintWriter(csvFileWrite)) {
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Данные записаны в файл \"" + csvFileWrite + "\".");

        // 2. Реализовать загрузку данных из csv файла. Файл читается целиком.

        System.out.println();
        System.out.println("Задача 2.");

        // файл для чтения
        File csvFileReader = new File("src/HomeWork_5/HM5-rw.csv");
        AppData appData = new AppData();

        // читаем файл
        byte[] buf = new byte[20];
        try (FileInputStream in = new FileInputStream(csvFileReader)) {
            int count;
            String s = ""; // временная переменная для записи прочитанного
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    s += (char) buf[i];
                }
            }
//            System.out.println(s);
            String[] rows = s.split("\n"); // разбиваем считанные данные на части (разделитель перевод строки)
//            System.out.println(Arrays.toString(rows));
            int [][] arr = new int [rows.length][3]; // временный массив
            for (int i = 0; i < rows.length; i++) {
                String[] col = rows[i].split(";"); // разбиваем считанные данные на части (разделитель ;)
                for (int j = 0; j < col[0].length(); j++) {
                    if (i == 0) { // заголовок в первой (0) строке
                        appData.setHeader(col);
                    } else {
                        arr[i][j] = Integer.parseInt(col[j]);
                        appData.setData(arr);
                    }
                }
            }

            // получение строк для провеки
//            System.out.println(rows[0]);
//            System.out.println(rows[1]);
//            System.out.println(rows[2]);
//            System.out.println();

            appData.getHeader();
            appData.getData();
        } catch (IOException e) {
            System.out.println("Файла не существует!");
            e.printStackTrace();
        }

    }
}
