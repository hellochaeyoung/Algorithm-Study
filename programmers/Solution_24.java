package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_24 {

    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int fromX, fromY, toX, toY;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int rows = 100;
        int columns = 97;

        //int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        //int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        int[][] queries = {{1,1,100,97}};

        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        map = new int[rows][columns];
        answer = new int[queries.length];

        int num = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                map[i][j] = ++num;
            }
        }



        for(int i=0;i< queries.length;i++) {
            fromX = queries[i][0]-1;
            fromY = queries[i][1]-1;
            toX = queries[i][2]-1;
            toY = queries[i][3]-1;

            dfs(fromX, fromY+1, 0, map[fromX][fromY]);

            answer[i] = min;
            min = Integer.MAX_VALUE;
        }

        return answer;
    }

    static void dfs(int x, int y, int d, int n) {

        if(x == fromX && y == fromY) {
            map[x][y] = n;
            min = Math.min(min, map[x][y]);
            return;
        }

        int nx = x + dx[d];
        int ny = y + dy[d];
        int num = map[x][y];

        if(nx < fromX || ny < fromY || nx > toX || ny > toY) {
            d = (d + 1) % 4;
            dfs(x, y, d, n);
            return;
        }

        map[x][y] = n;
        min = Math.min(min, map[x][y]);
        dfs(nx, ny, d, num);
    }

}
