package boj;

import java.io.*;
import java.util.*;

public class Main_2206 {

    static class Node {
        int x,y,c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int N, M;
    static char[][] map;
    static int[][] dist;
    static boolean[][][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        if(N-1 == 0 && M-1 == 0) {
            System.out.println(1);
            System.exit(0);
        }

        bfs(0,0, 0);

    }

    static void bfs(int x, int y, int c) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x,y,c));

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i=0;i<4;i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(map[nx][ny] == '1') {
                    if(node.c == 0 && !visited[1][nx][ny]) {
                        visited[node.c][nx][ny] = true;
                        dist[nx][ny] = dist[node.x][node.y] + 1;
                        q.offer(new Node(nx, ny, 1));
                    }
                }else {
                    if(!visited[node.c][nx][ny]) {
                        visited[node.c][nx][ny] = true;
                        dist[nx][ny] = dist[node.x][node.y] + 1;
                        q.offer(new Node(nx, ny, node.c));
                    }
                }

                if(nx == N-1 && ny == M-1) {
                    System.out.println(dist[nx][ny] + 1);
                    System.exit(0);
                }
            }
        }

        System.out.println(-1);
    }
}
