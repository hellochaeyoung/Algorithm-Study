package boj;

import java.util.*;
import java.io.*;

public class Main_3187 {

    static String[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1,0,1,0};
    static int[] moveY = {0,-1,0,1};

    static int R;
    static int C;

    static int v = 0;
    static int k = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int i=1;i<=R;i++) {
            String row = br.readLine();
            for(int j=1;j<=C;j++) {
                arr[i][j] = String.valueOf(row.charAt(j-1));
            }
        }

        int totalK = 0;
        int totalV = 0;
        for(int i=1;i<=R;i++) {
            for(int j=1;j<=C;j++) {
                if(!visited[i][j]){
                    dfs(i,j);
                    if( k > v) {
                        totalK += k;
                    }else {
                        totalV += v;
                    }
                    k = 0;
                    v = 0;
                }
            }
        }

        System.out.println(totalK + " " + totalV);

    }

    static void dfs(int n, int m) {

        if(n <= 0 || n > R || m <= 0 || m > C) {
            return;
        }

        if(visited[n][m]) {
            return;
        }

        visited[n][m] = true;
        if (!arr[n][m].equals("#")) {
            if(arr[n][m].equals("v")) {
                v++;
            }

            if(arr[n][m].equals("k")) {
                k++;
            }

            for(int i=0;i<moveX.length;i++) {
                int x = n + moveX[i];
                int y = m + moveY[i];

                dfs(x,y);
            }

        }

        return;

    }
}
