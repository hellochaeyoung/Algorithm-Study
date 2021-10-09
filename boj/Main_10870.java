package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = fibo(n);

        System.out.println(answer);

    }

    public static int fibo(int n) {

        if(n == 0) {
            return 0;
        }else if( n == 1) {
            return 1;
        }else {
            return fibo(n-1) + fibo(n-2);
        }

    }
}
