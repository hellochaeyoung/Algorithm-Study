package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657 {

    static int[] input;
    static boolean[] visited;
    static int[] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
            //System.out.println(input[i]);
        }

        Arrays.sort(input);

        dfs(0,0);
    }

    static void dfs(int start, int depth) {

        if(depth == M) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start;i<N;i++) {
            arr[depth] = input[i];

            dfs(i,depth+1);
        }

        return;
    }
}
