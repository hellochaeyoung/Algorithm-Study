package boj;

import java.io.*;
import java.util.*;

public class Main_11559 {

    static final int N = 12, M = 6;
    static char[][] arr;
    static ArrayList<Character>[] arrList;
    static int cnt = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[N][M];
        arrList = new ArrayList[M];
        visited = new boolean[M][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for(int i=0;i<M;i++) {
            arrList[i] = new ArrayList<>();
            for(int j=N-1;j>=0;j--) {
                arrList[i].add(arr[j][i]);
            }
        }

        int count = 0;

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                dfs(i, j, arrList[i].get(j));

                if(cnt >= 4) {
                    count++;
                }

                cnt = 0;
            }
        }

        System.out.println(count);


    }

    static void dfs(int x, int y, char ch) {

        if(x < 0 || x >= M || y < 0 || y >= N || visited[x][y]) {
            return;
        }


        if(arrList[x].get(y) == '.' || arrList[x].get(y) != ch) {
            return;
        }

        visited[x][y] = true;
        cnt++;
        dfs(x+1, y, ch);
        dfs(x-1, y, ch);
        dfs(x, y+1, ch);
        dfs(x, y-1, ch);

        if(cnt >= 4) {
            arrList[x].remove(y);
            arrList[x].add('.');
        }

        visited[x][y] = false;

    }

}
