package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_46 {

    static boolean[][][] visited;

    // 하, 우, 상, 좌
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int price = Integer.MAX_VALUE;

    static int N,M;
    static int[][] map;

    public static void main(String[] args) {

        //{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}
        //int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {

        N = M = board.length;

        visited = new boolean[N][M][4];

        map = board;

        bfs(board, 0, 0, N, M);
        //dfs(0,0,-1,N,M);

        return price;
    }

    static void bfs(int[][] board, int x, int y, int N, int M) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0,0,0});
        visited[x][y][0] = true;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                int dir = arr[2];
                int street = arr[3];
                int corner = arr[4];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 1) {
                    continue;
                }



                if(!visited[nx][ny][i]) {

                    int tmp = corner;
                    if(dir != -1) {
                        int gap = Math.abs(i - dir);
                        if(gap == 1 || gap == 3)  {
                            tmp = corner+1;
                        }
                    }

                    if(nx == N-1 && ny == M-1) {
                        int cost = (street + 1) * 100 + tmp * 500;
                        //System.out.println(street+1 + " " + corner);
                        //System.out.println(price + " " + cost);
                        price = Math.min(price, cost);

                        break;
                    }

                    visited[nx][ny] = true;

                    queue.add(new int[] {nx, ny, i, street+1, tmp});
                }

            }
        }

    }

}
