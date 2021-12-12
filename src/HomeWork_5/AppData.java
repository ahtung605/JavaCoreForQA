package HomeWork_5;

import java.util.Arrays;

/**
 * @author Konstantin Babenko
 * @create 12.12.2021
 */

public class AppData {
    private String[] header;
//    private String[] data;
    private int[][] data;

    public void getHeader() {
        System.out.println(Arrays.toString((header)));
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void getData() {
        System.out.println(Arrays.toString((data)));
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void setData(int[][] data) {
        this.data = data;
    }

}
