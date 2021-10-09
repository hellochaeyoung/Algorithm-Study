package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = factorial(N);

        System.out.println(answer);

    }

    public static int factorial(int n) {

        if(n == 0 || n == 1) {
            return 1;
        }else {
            return n * factorial(n-1);
        }

    }
}
