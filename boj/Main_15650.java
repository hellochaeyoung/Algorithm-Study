package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 1,0);

    }

    static void dfs(int n, int m, int start, int depth) {

        if( depth == m) {
            for(int i=0;i<arr.length;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }


        for(int i=start;i<=n;i++) {
            arr[depth] = i;
            dfs(n,m, i+1,depth+1);
        }
        return;
    }
}
