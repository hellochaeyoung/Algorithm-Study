package programmers;

import java.util.*;

public class Solution_28 {

    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int M, N;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;

    static int area = 0;
    static int cnt = 0;

    public static void main(String[] args) {

        int m = 6, n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m, n, picture)));

    }

    public static int[] solution(int m, int n, int[][] picture) {

        numberOfArea =0;
        maxSizeOfOneArea = Integer.MIN_VALUE;
        int[] answer = new int[2];

        M = m;
        N = n;

        map = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = picture[i][j];
            }
        }

        visited = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    area = map[i][j];
                    cnt = 1;
                    dfs(i,j);

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    numberOfArea++;

                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;

    }

    static void dfs(int x, int y) {

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
                 continue;
            }

            if(map[nx][ny] != area) {
                continue;
            }

            if(!visited[nx][ny]) {
                visited[nx][ny] = true;

                cnt++;
                dfs(nx, ny);
            }
        }
    }
}
