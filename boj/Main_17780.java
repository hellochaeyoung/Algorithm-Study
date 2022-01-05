package boj;

import java.io.*;
import java.util.*;

class Horse {
    int number,x,y,direction, parent;

    public Horse(int number, int x, int y, int direction, int parent) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.parent = parent;
    }
}

public class Main_17780 {

    static int N,K;
    static int[][] arr;
    static LinkedList<Horse>[][] board;
    static ArrayList<Horse> list = new ArrayList<>();
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        board = new LinkedList[N+1][N+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new LinkedList<>();
            }
        }

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ////
            if(d == 1) d = 0;
            else if(d == 4) d = 1;

            Horse horse = new Horse(i+1, x, y, d, i+1);
            board[x][y].add(horse);
            list.add(horse);
        }

        play();

    }

    static void play() {

        for(int c = 1; c <= 1000 ; c++) {
            for(int i=0;i<K;i++) {
                Horse h = list.get(i);

                int x = h.x;
                int y = h.y;
                int d = h.direction;

                if(board[h.x][h.y].get(0).number == i+1) { // 다른 말 위에 있다면 두 값이 다름

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx > N || nx <= 0 || ny > N || ny <= 0 || arr[nx][ny] == 2) {
                        board[x][y].get(0).direction = d = (d+2) % 4;
                        nx = x + dx[d];
                        ny = y + dy[d];

                        if(nx > N || nx <= 0 || ny > N || ny <= 0 || arr[nx][ny] == 2) {
                            continue;
                        }else {
                            if (move(x,y,nx,ny, arr[nx][ny])) {
                                System.out.println(c);
                                return;
                            }
                        }
                    }else {
                        if(move(x,y,nx,ny,arr[nx][ny])) {
                            System.out.println(c);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static boolean move(int x, int y, int nx, int ny, int color) {

        if(color == 0) {
            while(board[x][y].size() > 0) {
                Horse h = board[x][y].removeFirst();
                h.x = nx;
                h.y = ny;
                board[nx][ny].add(h);
            }
        }else {
            while(board[x][y].size() > 0) {
                Horse h = board[x][y].removeLast();
                h.x = nx;
                h.y = ny;
                board[nx][ny].add(h);
            }
        }

        if(board[nx][ny].size() >= 4) {
            return true;
        }else {
            return false;
        }
    }

}
