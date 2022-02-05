package boj;

import java.io.*;
import java.util.*;

public class Main_11559 {

    static final int N = 12, M = 6;
    static char[][] arr;
    static ArrayList<Character>[] arrList;
    static int cnt = 0;
    static boolean[][] visited;
    static boolean[][] removed;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[N][M];
        arrList = new ArrayList[M];
        visited = new boolean[M][N];
        removed = new boolean[M][N];

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

        while(true) {
            visited = new boolean[M][N];
            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(arrList[i].get(j) != '.' && !visited[i][j]) {
                        cnt = 1;
                        dfs(i, j, arrList[i].get(j));

                    }

                }
            }

            if(remove()) {
                count++;
            }else {
                break;
            }
        }


        System.out.println(count);


    }

    static void dfs(int x, int y, char ch) {

        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N || arrList[nx].get(ny) != ch) {
                continue;
            }

            if(!visited[nx][ny] && arrList[nx].get(ny) == ch) {
                cnt++;
                dfs(nx, ny, ch);
            }
        }

        System.out.println(x + " " + y + " " + ch + " " + cnt);
        if(cnt >= 4) {
            //return true;
            arrList[x].set(y, '*');
        }


    }

    static boolean remove() {

        boolean modified = false;

        for(int i=0;i<M;i++) {
            arrList[i].removeIf(ch -> ch.equals('*'));
            if(arrList[i].size() != N) {
                modified = true;
                int size = N - arrList[i].size();
                for(int j=0;j<size;j++) {
                    arrList[i].add('.');
                }
            }
        }

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(arrList[i].get(j));
            }
            System.out.println();
        }

        System.out.println();

        return modified;
    }

}
