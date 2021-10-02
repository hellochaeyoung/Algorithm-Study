package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1929 {

    public static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isNotPrime = new boolean[N + 1];

        checkIsPrime(N);

        printPrime(M,N);

    }

    public static void checkIsPrime(int end) {

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i=2;i<=Math.sqrt(end);i++) {
            for(int j = i*i; j<end+1; j = j+i) {
                if(!isNotPrime[j]) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public static void printPrime(int start, int end) {

        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end + 1; i++) {
            if(!isNotPrime[i]) {
                sb.append(i + "\n");
                //System.out.println(i);
            }
        }
        System.out.println(sb.toString());
    }
}
