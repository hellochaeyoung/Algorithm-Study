package practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KI_5 {

    static int N,M;
    static int[][] map;

    //하, 우, 상, 좌
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        int[][] rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[] operations = {"Rotate", "ShiftRow"};

        System.out.println(Arrays.deepToString(solution(rc, operations)));
    }

    public static int[][] solution(int[][] rc, String[] operations) {

        N = rc.length;
        M = rc[0].length;

        map = rc;

        for(String op : operations) {
            if(op.equals("Rotate")) rotate();
            else shiftRow();
        }
        return map;
    }

    static void shiftRow() {

        int[] temp = map[map.length-1];

        List<int[]> list = Arrays.stream(map).collect(Collectors.toList());

        int[] arr = list.remove(list.size()-1);
        list.add(0, arr);

        map = list.toArray(new int[N][M]);

        /*for(int i=N-1;i>0;i--) {
            map[i] = map[i-1];
        }
        map[0] = temp;*/
    }

    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        int temp = map[0][0];

        queue.add(new int[]{0,0,0});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();

            int x = arr[0];
            int y = arr[1];

            int d = arr[2];
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                d++;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            if(nx == 0 && ny == 0) {
                map[x][y] = temp;
                break;
            }

            map[x][y] = map[nx][ny];

            queue.add(new int[] {nx, ny, d});
        }
    }

    static void rotate() {

        int temp = map[0][0];
        int[] arr = {map[0][0], map[0][M-1], map[N-1][M-1], map[N-1][0]};

        if(N != M) {
            for(int i=0;i<N-1;i++) {
                map[i][0] = map[i+1][0];
            }
            for(int i=0;i<M-1;i++) {
                map[N-1][i] = map[N-1][i+1];
            }

            for(int i=N-1;i>0;i--) {
                map[i][M-1] = map[i-1][M-1];
            }

            for(int i=M-1;i>0;i--) {
                map[0][i] = map[0][i-1];
            }

            map[0][1] = temp;

        }else {
            for(int i=0;i<N-1;i++) {
                map[i][0] = map[i+1][0];
                map[N-1][i] = map[N-1][i+1];
            }

            for(int i=N-1;i>0;i--) {
                map[i][M-1] = map[i-1][M-1];
                map[0][i] = map[0][i-1];
            }

            map[0][1] = arr[0];
            map[1][M-1] = arr[1];
            map[N-1][M-2] = arr[2];
            map[N-2][0] = arr[3];
        }
    }
}
