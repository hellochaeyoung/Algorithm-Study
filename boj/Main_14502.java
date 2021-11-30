package boj;

import java.io.*;
import java.util.*;

/*
문제 막혔던 이유
1. 벽의 위치를 임의로, 즉 세울 수 있는 모든 경우의 수를 다 따지는 방법 생각하지 못함, 아니 이게 성공할지 의심해 하지 않음
2. 벽의 위치도 바뀌고 그에 따라 퍼지는 바이러스 위치도 달라지기 때문에 맵을 2개를 복사해서 사용해야함
=> 한마디로 1번 생각에서 막혀서 (더 효율적인 방법이 있을 줄 알고) 다른 방법을 생각해내지 못했는데 다음부턴 도전해보고 안되면 더 효율적인 방법 생각해볼 것!
 */
public class Main_14502 {

    static class Location {
        public int x;
        public int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static int[][] map;
    static int[][] input;
    static ArrayList<Location> virusList = new ArrayList<>();
    static int[] moveX = {0,-1,0,1};
    static int[] moveY = {1,0,-1,0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N][M];
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                input[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    virusList.add(new Location(i,j));
                }
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(input[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(1);
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int count) {

        if(count == 3) {
            bfs();
            return;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count+1);

                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {

        int[][] m = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                m[i][j] = map[i][j];
            }
        }
        Queue<Location> q = new LinkedList<>();
        for(Location loc : virusList) {
            q.add(loc);
            for(int i=0;i<4;i++) {
                int x = loc.x + moveX[i];
                int y = loc.y + moveY[i];
                q.add(new Location(x,y));
            }
        }

        while(!q.isEmpty()) {
            Location loc = q.remove();
            if(loc.x < 0 || loc.y < 0 || loc.x >= N || loc.y >= M) {
                continue;
            }

            if(m[loc.x][loc.y] == 0) {
                m[loc.x][loc.y] = 2;

                for(int i=0;i<4;i++) {
                    q.add(new Location(loc.x+moveX[i], loc.y+moveY[i]));
                }
            }
        }

        getMaxOfSafeArea(m);
    }

    static int getMaxOfSafeArea(int[][] map) {

        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(max, cnt);

        return max;
    }
}
