package boj;

import java.io.*;
import java.util.*;

public class Main_3085 {

    static int N;
    static String[][] arr;
    static int[] moveX = {1,0};
    static int[] moveY = {0,1};
    static int max = 1;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = s.split("")[j];
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                search(i,j);
            }
        }

        System.out.println(max);
    }

    static public void search(int x, int y) {

        for(int i=0;i<2;i++) {

            int newX = x + moveX[i];
            int newY = y + moveY[i];

            if(newX >= N || newX < 0 || newY >= N || newY < 0) { // 범위 넘어가는 경우
                continue;
            }

            if(arr[x][y].equals(arr[newX][newY])) { // 같은 색이 인접한 경우
                continue;
            }

            String temp = arr[x][y];
            arr[x][y] = arr[newX][newY];
            arr[newX][newY] = temp;

            for(int n=0;n<N;n++) {
                int rowCount = 1;
                int colCount = 1;
                for(int m=0;m<N-1;m++) {

                    if(arr[n][m].equals(arr[n][m+1])) {
                        rowCount += 1;
                    }else {
                        rowCount = 1;
                    }

                    max = Math.max(max, rowCount);

                    if(arr[m][n].equals(arr[m+1][n])) {
                        colCount += 1;
                    }else {
                        colCount = 1;
                    }

                    max = Math.max(max, colCount);
                }
            }

            temp = arr[x][y];
            arr[x][y] = arr[newX][newY];
            arr[newX][newY] = temp;

        }
    }

}
