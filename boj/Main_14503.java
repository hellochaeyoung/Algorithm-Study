package boj;

import java.util.*;
import java.io.*;

public class Main_14503 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int rx = Integer.parseInt(st.nextToken());
        int ry = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(rx,ry,dir);

        System.out.println(count);
    }

    static void dfs(int x, int y, int dir) {

        if(!visited[x][y]) {
            visited[x][y] = true; // 현재 위치를 청소한다.
            count++;
        }

        int d = dir;
        int i=0;
        boolean clean = false;

        while(i < 4) {
            i++;
            d = (d == 0) ? 3 : (d-1); // 현재 방향 기준 왼쪽 방향 설정

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(visited[nx][ny] || map[nx][ny] == 1) { // 청소한 구역 or 벽
                clean = true;
                continue;
            }

            clean = false;

            if(!visited[nx][ny] && map[nx][ny] == 0) {
                dfs(nx, ny, d);
                break;
            }
        }

        if(clean) {
            int nx = x + (dx[d] * -1);
            int ny = y + (dy[d] * -1);

            if(map[nx][ny] == 1) {
                return;
            }

            dfs(nx, ny, d);
        }
    }
}
