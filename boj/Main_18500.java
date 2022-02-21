package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18500 {

    static int R, C, N;
    static char[][] arr;
    static boolean[][] visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int i=1;i<=R;i++) {
            String str = br.readLine();
            for(int j=1;j<=C;j++) {
                arr[i][j] = str.charAt(j-1);
            }
        }

        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        int start = 0;
        for(int n : list) {
            if(cnt % 2 == 0) {
                start = 1;
            }else {
                start = C;
            }
            cnt++;
            n = (R - n) + 1;
            destroy(n, start);
            check();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=R;i++) {
            for(int j=1;j<=C;j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void destroy(int n, int start) {

        if(start == 1) {
            for(int i=start;i<=C;i++) {
                if(arr[n][i] == 'x') {
                    arr[n][i] = '.';
                    break;
                }
            }
        }else {
            for(int i=start;i>=1;i--) {
                if(arr[n][i] == 'x') {
                    arr[n][i] = '.';
                    break;
                }
            }
        }

    }

    static void check() {
        visited = new boolean[R+1][C+1];
        find();
        move();
    }

    static void find() {
        for(int i=1;i<=C;i++) {
            if(!visited[R][i] && arr[R][i] == 'x') {
                bfs(R, i);
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.add(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] mineral = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = mineral[0] + dx[i];
                int ny = mineral[1] + dy[i];

                if(nx <= 0 || nx > R || ny <= 0 || ny > C) {
                    continue;
                }

                if(!visited[nx][ny] && arr[nx][ny] == 'x') {
                    visited[nx][ny] = true;

                    queue.add(new int[] {nx, ny});
                }
            }
        }

    }

    static void move() {
        List<int []> list = new ArrayList<>();
        for(int i=1;i<=R;i++) {
            for(int j=1;j<=C;j++) {
                if(arr[i][j] == 'x' && !visited[i][j]) {
                    arr[i][j] = '.';
                    list.add(new int[] {i, j});
                }
            }
        }

        int min = 101;
        for(int[] n : list) {
            int x = n[0];
            int y = n[1];

            while(x <= R) {
                if(!visited[x][y] && arr[x][y] == 'x') {
                    break;
                }
                if(visited[x][y] && arr[x][y] == 'x') {
                    min = Math.min(min, x - n[0] - 1);
                    break;
                }
                if(x == R) {
                    min = Math.min(min, R - n[0]);
                    break;
                }
                x++;
            }

        }

        for(int[] n : list) {
            int x = n[0];
            int y = n[1];

            arr[x + min][y] = 'x';
        }
    }
}
