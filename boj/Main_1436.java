package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int n = 666;
        int count = 0;
        while(true) {

            String s = Integer.toString(n);

            if(s.contains("666")) {
                count++;
            }

            if(count == N) {
                break;
            }

            n++;

        }

        System.out.println(n);

    }
}
