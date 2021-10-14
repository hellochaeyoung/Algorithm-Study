package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {

    static int[] numbers;
    static int[] arr;
    static boolean[] check;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        arr = new int[M];
        check = new boolean[N];

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
            for(int n : arr) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<numbers.length;i++) {
            if(!check[i]) {
                check[i] = true;
                arr[depth] = numbers[i];

                dfs(depth+1);
                check[i] = false;

            }
        }
        return;
    }
}
