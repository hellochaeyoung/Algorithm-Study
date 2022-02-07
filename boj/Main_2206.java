package boj;

import java.io.*;
import java.util.*;

public class Main_2206 {

    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(str.split("")[j]);
            }
        }

        //bfs(0,0);

        visited[0][0] = true;
        dfs(0,0);

        if(count == 0) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }


    }

    static void dfs(int x, int y) {

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx == N-1 && ny == M-1) {
                count++;
                return;
            }

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) { // 영역 체크
                continue;
            }

            if(map[nx][ny] == 1 && !visited[nx][ny]) {

                if(!check) {
                    visited[nx][ny] = true;
                    count++;
                    check = true;

                    dfs(nx, ny);

                    check = false;
                    count--;
                }
            }

            if(!visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                count++;
                dfs(nx, ny);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        visited[x][y] = true;
        q.offer(new Node(x,y));

        while(!q.isEmpty()) {
            Node node = q.poll();

            if(node.x == N-1 && node.y == M-1) {
                return;
            }

            for(int i=0;i<4;i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    count++;
                }
            }
        }
    }
}
