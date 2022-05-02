package programmers;

import java.util.*;

public class Solution_41 {

    static char[][][] map;
    static boolean[][][] visited;

    // 우, 하, 좌, 상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int N,M;

    public static void main(String[] args) {
        String[] grid = {"SL", "LR"};

        System.out.println(Arrays.toString(solution(grid)));
    }

    public static int[] solution(String[] grid) {

        N = grid.length;
        M = grid[0].length();

        map = new char[N][M][4];
        visited = new boolean[N][M][4];

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int z=0;z<4;z++) {
                    if(!visited[i][j][z]) {
                        list.add(bfs(grid, i, j, z));
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    static int bfs(String[] grid, int x, int y, int d) {

        int cnt = 0;

        while(true) {
            if(visited[x][y][d]) {
                break;
            }

            cnt++;
            visited[x][y][d] = true;

            if(grid[x].charAt(y) == 'L') {
                d = d == 0 ? 3 : d-1;
            }else if(grid[x].charAt(y) == 'R') {
                d = d == 3 ? 0 : d+1;
            }

            x = (x + dx[d] + N) % N;
            y = (y + dy[d] + M) % M;
        }

        return cnt;
    }


}
