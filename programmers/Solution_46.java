package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_46 {

    // 하, 우, 상, 좌
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int N,M;
    static int[][][] map;

    public static void main(String[] args) {

        //{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}
        //int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {

        N = M = board.length;

        map = new int[N][M][4];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                Arrays.fill(map[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(board, 0, 0);

        return Arrays.stream(map[N-1][M-1]).min().getAsInt();
    }

    static void bfs(int[][] board, int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0,0});
        queue.add(new int[]{x,y,0,1});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                int cost = arr[2] + (arr[3] == i ? 100 : 600);

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 1 || map[nx][ny][i] <= cost) {
                    continue;
                }

                map[nx][ny][i] = cost;
                queue.add(new int[] {nx, ny, cost, i});
            }
        }

    }

}
