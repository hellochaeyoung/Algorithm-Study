package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4 {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 0);

        System.out.println(cnt);

    }

    static void dfs(int depth, int count, int sum, int start) {

        if(depth == N || count == 3) {
            if(sum >= 2000 && sum <= 2500) {
                cnt++;
            }
            return;
        }

        for(int i=start;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;

                dfs(depth+1, count+1, sum+arr[i], start+1);

                visited[i] = false;
            }
        }
    }
}
