package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {

    static int[][] map;
    static int N, line;
    static boolean dir;

    static List<Integer> list = new ArrayList<>();

    // 동, 남, 서, 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int setDirection(int d) { //

        if(dir) {
            d = (d + 1) % 4;
        }else {
            if(d == 0) {
                d = 3;
            }else {
                d = (d - 1) % 4;
            }
        }

        return d;
    }

    static void dfs(int x, int y, int d) {

        if(d == 4) {
            d = 0;
        }

        Queue<int []> queue = new LinkedList<>();

        int num = 1;
        int cnt = 0;
        map[x][y] = num;
        queue.add(new int[] {x, y, d});
        while(!queue.isEmpty()) {
            int [] arr = queue.poll();

            if(num == line) { //
                break;
            }

            if(num == list.get(cnt)) {
                d = setDirection(d);
                cnt++;
            }

            int nx = arr[0] + dx[d];
            int ny = arr[1] + dy[d];

            map[nx][ny] = ++num;

            queue.add(new int[] {nx, ny, d});

        }

    }
    public static int[][] solution(int n, boolean clockwise) {

        line = (int) Math.ceil((double) (n*n) / 4);
        N = n;
        map = new int[N][N];
        dir = clockwise;

        int sum = 0;
        for(int i=N-1;i>=1;i-=2) {
            sum += i;
            list.add(sum);
        }

        int start = 0;
        if(!clockwise) {
            start = 1;
        }

        dfs(0,0,start);
        dfs(0, n-1, ++start);
        dfs(n-1, n-1, ++start);
        dfs(n-1, 0, ++start);

        return map;
    }

    public static void main(String[] args) {

        int[][] answer = solution(9, true);

        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer.length;j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}
