package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {

    static String[] arr;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }

        int T = Integer.parseInt(br.readLine());

        input = new String[T];
        for(int i=0;i<T;i++) {
            input[i] = br.readLine();
        }

        for(String st : input) {
            int cnt = count(st);
            System.out.println(cnt);
        }
    }

    static int count(String word) {
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i].startsWith(word)) {
                count++;
            }
        }

        return count;
    }
}
