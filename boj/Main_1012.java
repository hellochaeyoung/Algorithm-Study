package boj;

import java.io.*;
import java.util.*;

public class Main_1012 {

    static int M;
    static int N;
    static int[][] ground;
    static boolean[][] visited;
    static int[] moveX = {0,-1,0,1};
    static int[] moveY = {-1,0,1,0};
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ground = new int[M][N];
            visited = new boolean[M][N];

            for(int i=0;i<K;i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                ground[X][Y] = 1;
            }

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(!visited[i][j] && ground[i][j] == 1) {
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;
        }

    }

    static void dfs(int i, int j) {

        if( i < 0 || i >= M || j < 0 || j >= N) {
            return;
        }

        if(visited[i][j] || ground[i][j] == 0) {
            return;
        }

        if(!visited[i][j] && ground[i][j] == 1) {
            visited[i][j] = true;

            for(int t=0;t<4;t++) {
                dfs(i+moveX[t], j+moveY[t]);
            }
        }
    }
}
