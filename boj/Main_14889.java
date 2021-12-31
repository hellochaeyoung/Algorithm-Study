package boj;

import java.io.*;
import java.util.*;

public class Main_14889 {

    static int N;
    static int[][] arr;;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];


        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);
    }

    static void dfs(int depth, int start) {

        if(depth == N/2) {
            getMinOfAbility();
            return;
        }

        for(int i=start;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;

                dfs(depth+1, ++start);

                visited[i] = false;
            }
        }

        return;

    }

    static void getMinOfAbility() {

        int start = 0, link = 0;

        for(int i=0;i<N-1;i++) {
            for(int j=i;j<N;j++) {

                if(visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }

                else if(!visited[i] && !visited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int ability = Math.abs(start - link);

        if(ability == 0) {
            System.out.println(ability);
            System.exit(0);
        }

        min = Math.min(min, ability);
    }
}
