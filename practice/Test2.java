package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {

    static int[][] map;
    static int N;
    static int line;

    static List<Integer> list = new ArrayList<>();

    // 동, 남, 서, 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void bfs(int x, int y, int d) {

        if(d == 4) {
            d = 0;
        }

        Queue<int []> queue = new LinkedList<>();

        int num = 1;
        map[x][y] = num;
        queue.add(new int[] {x, y, d});
        while(!queue.isEmpty()) {
            int [] arr = queue.poll();

            int nx = arr[0] + dx[d];
            int ny = arr[1] + dy[d];

            map[nx][ny] = ++num;

            if(num == list.get(0)) {
                d = (d + 1) % 4;
                list.remove(0);
            }

            queue.add(new int[] {nx, ny, d});

        }

    }
    public static int[][] solution(int n, boolean clockwise) {
        int[][] answer = {};

        line = (int) Math.ceil((double) (n*n) / 4);

        N = n;
        map = new int[N][N];

        int sum = 0;
        for(int i=N-1;i>=1;i-=2) {
            sum += i;
            list.add(sum);
        }
        list.add(sum + 1);


        int start = 0;
        if(!clockwise) {
            start = 1;
        }

        bfs(0,0,start);
        bfs(0, n-1, ++start);
        bfs(n-1, n-1, ++start);
        bfs(n-1, 0, ++start);

        return map;
    }

    public static void main(String[] args) {

        int[][] answer = solution(5, true);

        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer.length;j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}
