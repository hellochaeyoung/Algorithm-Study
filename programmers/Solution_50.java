package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_50 {

    static int N,M;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        //int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        N = maps.length;
        M = maps[0].length;

        visited = new boolean[N][M];

        answer = bfs(maps);

        return answer;
    }

    static int bfs(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                int nc = arr[2];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0) continue;

                if(nx == N-1 && ny == M-1) {
                    return nc+1;
                }

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    queue.add(new int[] {nx, ny, nc+1});
                }
            }
        }

        return -1;
    }
}
