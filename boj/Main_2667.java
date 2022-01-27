package boj;

import java.io.*;
import java.util.*;

public class Main_2667 {

    static int N;
    static int[][] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(str.split("")[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(dfs(i,j)) {
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }

    static boolean dfs(int x, int y) {

        if(x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }

        if(arr[x][y] == 1) {
            arr[x][y] = 0;
            cnt++;
            dfs(x+1,y);
            dfs(x-1,y);
            dfs(x,y+1);
            dfs(x,y-1);
            return true;
        }

        return false;
    }
}
