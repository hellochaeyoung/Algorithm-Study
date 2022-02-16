package boj;

import java.io.*;
import java.util.*;

public class Main_2931 {

    static class Node {
        int x, y;
        int[] direction;

        public Node(int x, int y, int[] direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] check;
    static int startX, startY;
    static int endX, endY;

    //남, 동, 북, 서
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        check = new int[R][C];

        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'M') {
                    startX = i;
                    startY = j;
                }else if(map[i][j] == 'Z') {
                    endX = i;
                    endY = j;
                }
            }
        }

    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y, new int[4]));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(map[n.x][n.y] == 'Z') {
                break;
            }

            for(int i=0;i<4;i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int[] dir = new int[4];
                    Node node;
                    if(map[nx][ny] == '|') {
                        dir[0] = 1;
                        dir[2] = 1;
                    }else if(map[nx][ny] == '-') {
                        dir[1] = 1;
                        dir[3] = 1;
                    }else if(map[nx][ny] == '1') {
                        dir[0] = 1;
                        dir[1] = 1;
                    }else if(map[nx][ny] == '2') {
                        dir[1] = 1;
                        dir[2] = 1;
                    }else if(map[nx][ny] == '3') {
                        dir[2] = 1;
                        dir[3] = 1;
                    }else if(map[nx][ny] == '4') {
                        dir[0] = 1;
                        dir[3] = 1;
                    }else {
                        dir[0] = 1;
                        dir[1] = 1;
                        dir[2] = 1;
                        dir[3] = 1;
                    }

                    node = new Node(nx, ny, dir);
                    queue.add(node);
                }

                if(map[nx][ny] == '.') {
                    
                }
            }
        }
    }

    static void findBFS() {
        Queue<Node> queue = new LinkedList<>();



    }
}
