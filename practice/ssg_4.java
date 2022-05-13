package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ssg_4 {

    static int[][] map = new int[6][6];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt = 0;

    static boolean[][] check;

    public static void main(String[] args) {
        int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};

        //int[][] macaron = {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}};
        System.out.println(Arrays.toString(solution(macaron)));
    }

    public static String[] solution(int[][] macaron) {

        for(int i=0;i< macaron.length;i++) {

            int col = macaron[i][0] - 1;
            int color = macaron[i][1];

            map[0][col] = color; // 넣고
            move(); // 이동, 맨바닥부터 쌓임

            if(i > 1) { // 3개째부터
                while(true) {

                    boolean isCheck = false;
                    for(int a=0;a<6;a++){
                        for(int b=0;b<6;b++) {
                            if(map[a][b] != 0) {
                                check = new boolean[6][6];
                                int cnt = bfs(a, b, map[a][b]);

                                if(cnt > 2) { // 2개 이상이면
                                    checkMap();
                                    move();

                                    isCheck = true;
                                }
                            }
                        }
                    }

                    if(!isCheck) break;
                }

            }

            //cnt = 0;
        }

        for(int i=0;i<6;i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        String[] result = new String[6];
        for(int i=0;i<6;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<6;j++) {
                sb.append(map[i][j]);
            }
            result[i] = sb.toString();
        }

        return result;

    }


    static void checkMap() {

        for(int i=0;i<6;i++) {
            for(int j=0;j<6;j++) {
                if(check[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs(int x, int y, int c) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();

        cnt++;
        check[x][y] = true;
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= 6 || ny >= 6 ||
                        map[nx][ny] == 0 || map[nx][ny] != c) continue;

                if(!check[nx][ny]) {
                    check[nx][ny] = true;

                    cnt++;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return cnt;
    }

    static void move() {


        for(int i=0;i<6;i++) {
            for(int j=5;j>=0;j--) {
                if(map[j][i] == 0) {
                    for(int z=j-1;z>=0;z--) {
                        if(map[z][i] != 0) {
                            map[j][i] = map[z][i];
                            map[z][i] = 0;

                            break;
                        }
                    }
                }
            }
        }

    }
}
