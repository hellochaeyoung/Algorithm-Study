package practice;

import java.util.LinkedList;
import java.util.Queue;

public class Kpay_3 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        int rows = 2, columns = 3;
        int[][] maze = {{1,1,2,1},{2,1,2,2},{2,2,2,3},{1,2,1,3},{2,2,1,2}};
        int r1 = 3, c1 = 1, r2 = 1, c2 = 9;

        System.out.println(solution(rows, columns, maze, r1, c1, r2, c2));
    }

    public static int solution(int rows, int columns, int[][] maze, int r1, int c1, int r2, int c2) {

        N = rows+1;
        M = columns+1;

        map = new int[N*N][M*M];
        visited = new boolean[N*N][M*M];

        return bfs(r1, c1, r2, c2, maze);
    }

    static int bfs(int x, int y, int fx, int fy, int[][] maze) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                int c = arr[2];

                if(nx == fx && ny == fy) return ++c;

                if(nx <= 0 || nx > N || ny <= 0 || ny > M || visited[nx][ny]) continue;

                if(!checkWall(arr[0], arr[1], nx, ny, maze)) continue;

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny, ++c});
            }
        }

        return 0;
    }

    static boolean checkWall(int x, int y, int nx, int ny, int[][] maze) {

        for(int[] m : maze) {
            if(m[0] == x && m[1] == y && m[2] == nx && m[3] == ny)
                return true;
        }

        return false;
    }
}
