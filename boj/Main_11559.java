package boj;

import java.io.*;
import java.util.*;

class Puyo {
    int x, y;

    public Puyo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main_11559 {

    static final int N = 12, M = 6;
    static char[][] arr;
    static boolean[][] visited;

    static List<Puyo> list = new ArrayList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int count = 0;

        while(true) {
            visited = new boolean[N][M];
            boolean flag = true;

            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(arr[i][j] != '.' && !visited[i][j]) {
                        bfs(i, j);
                    }

                    if(list.size() >= 4) {
                        flag = false;
                        for(Puyo p : list) {
                            arr[p.x][p.y] = '.';
                        }
                    }

                    list.clear();
                }
            }
            remove();

            if(!flag) {
                count++;
            }else {
                break;
            }
        }


        System.out.println(count);


    }

    static void bfs(int x, int y) {

        Queue<Puyo> q = new LinkedList<>();

        visited[x][y] = true;
        char ch = arr[x][y];
        q.offer(new Puyo(x,y));

        list.add(new Puyo(x,y));

        while(!q.isEmpty()) {
            Puyo py = q.poll();

            for(int i=0;i<4;i++) {
                int nx = py.x + dx[i];
                int ny = py.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(!visited[nx][ny] && arr[nx][ny] == ch) {
                    visited[nx][ny] = true;
                    list.add(new Puyo(nx, ny));
                    q.offer(new Puyo(nx, ny));
                }
            }
        }


    }

    static void remove() {

        for(int i=0;i<M;i++) {
            for(int j=N-1;j>0;j--) {

                if(arr[j][i] == '.') {
                    for(int z=j-1;z>=0;z--) {
                        if(arr[z][i] != '.') {
                            arr[j][i] = arr[z][i];
                            arr[z][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

}
