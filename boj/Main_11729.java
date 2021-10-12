package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11729 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1,2,3);
    }

    static void hanoi(int N, int start, int sub, int end) {

        if(N==1) {
            System.out.println(start + " " + end);
            return;
        }

        hanoi(N-1, start, end, sub);

        System.out.println(start + " " + end);

        hanoi(N-1, sub, start, end);
    }
}
