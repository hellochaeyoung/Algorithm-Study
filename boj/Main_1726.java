package boj;

import java.io.*;
import java.util.*;

public class Main_1726 {

    static class Robot {
        int x,y,d,c;

        public Robot(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }

    static int N,M;
    static int[][] map;
    static int[][] orders;
    static boolean[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        orders = new int[M][N];
        visited = new boolean[M][N][4];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken())-1;
        int sy = Integer.parseInt(st.nextToken())-1;
        int sd = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken())-1;
        int ey = Integer.parseInt(st.nextToken())-1;
        int ed = Integer.parseInt(st.nextToken())-1;

        bfs(sx, sy, sd, ex, ey, ed);

    }

    static void bfs(int x, int y, int d, int ex, int ey, int ed) {
        Queue<Robot> q = new LinkedList<>();

        visited[x][y][d] = true;
        q.offer(new Robot(x, y, d,0));

        while(!q.isEmpty()) {
            Robot rb = q.poll();

            if(rb.x == ex && rb.y == ey && rb.d == ed) {
                System.out.println(rb.c);
                System.exit(0);
            }

            for(int j=1;j<=3;j++) { // +1, +2, +3
                int nx = rb.x + dx[rb.d] * j;
                int ny = rb.y + dy[rb.d] * j;

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if(!visited[nx][ny][rb.d]) {
                        visited[nx][ny][rb.d] = true;
                        q.offer(new Robot(nx, ny, rb.d, rb.c + 1));
                    }
                }else {
                    break;
                }
            }

            for(int i=0;i<4;i++) {
                if(rb.d != i && !visited[rb.x][rb.y][i]) {
                    int turn = 1;
                    if(rb.d == 0 && i == 1) { // Turn dir
                        turn++;
                    }else if(rb.d == 1 && i == 0) {
                        turn++;
                    }else if(rb.d == 2 && i == 3) {
                        turn++;
                    }else if(rb.d == 3 && i == 2) {
                        turn++;
                    }

                    visited[rb.x][rb.y][i] = true;
                    q.offer(new Robot(rb.x, rb.y, i, rb.c + turn));

                }

            }
        }
    }
}
