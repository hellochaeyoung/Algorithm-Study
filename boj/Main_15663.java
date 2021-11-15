package boj;

import java.util.*;
import java.io.*;

public class Main_15663 {

    static int[] arr;
    static int N;
    static int M;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
    }

    static void dfs(int depth) {

        if(depth == M) {
            for(int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];

                dfs(depth+1);
                visited[i] = false;
            }
        }

        return;
    }
}
