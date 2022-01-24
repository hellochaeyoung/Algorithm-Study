package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        long total = S;
        int i = 0;
        int count = 0;
        while(true) {
            i++;
            sum += i;
            total -= sum;
            count++;

            if(total <= i) {
                break;
            }

            total = S;
        }

        System.out.println(count);
    }
}
