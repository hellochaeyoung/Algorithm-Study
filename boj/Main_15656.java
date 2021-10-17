package boj;

import java.util.*;
import java.io.*;

public class Main_15656 {

    static int N;
    static int M;
    static int[] numbers;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0);

        System.out.println(sb);

    }

    static void dfs(int depth) {

        if(depth == M) {
            for(int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            arr[depth] = numbers[i];

            dfs(depth+1);
        }
        return;
    }
}
