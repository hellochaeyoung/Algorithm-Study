package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3053 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double r = Double.parseDouble(br.readLine());

        double area = Math.PI * r * r;
        double length = 2 * r * r;

        System.out.println(area);
        System.out.println(length);


    }
}
