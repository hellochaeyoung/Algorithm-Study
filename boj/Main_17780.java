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
    static ArrayList<Horse>[][] board;
    static boolean isFull = false;
    static Queue<Horse> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        board = new ArrayList[N+1][N+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Horse horse = new Horse(i+1, x, y, d, i+1);
            board[x][y].add(horse);
            queue.add(horse);
        }

        play();

    }

    static void play() {

        int cnt = 0;
        while(true) {
            cnt++; // 1부터 N번까지 말이 다 움직여야 1턴이기 때문에
            for(int i=0;i<K;i++) {
                Horse h = queue.poll();
                if(h.number == h.parent) { // 다른 말 위에 있다면 두 값이 다름
                    check(h);

                    if(isFull) {
                        System.out.println(cnt);
                        System.exit(0);
                    }

                    if(cnt > 1000) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
                queue.add(h);
            }

        }
    }

    static void check(Horse horse) {

        int x = horse.x;
        int y = horse.y;
        int d = horse.direction;

        if(d == 1) { // 오른쪽으로 이동

            move(x,y,0,1);

        }else if(d == 2) { // 왼쪽으로 이동

            move(x,y,0,-1);

        }else if(d == 3) { // 위로 이동

            move(x,y,-1,0);

        }else { // 아래로 이동

            move(x,y,1,0);

        }

        return;
    }

    static void move(int x, int y, int dx, int dy) {

        int nextColor = 0;

        if(x+dx > N || x+dx <=0 || y+dy > N || y+dy <=0) {
            nextColor = 2;
        }else {
            nextColor = arr[x+dx][y+dy];
        }

        while(true) {
            if(nextColor == 0) { // 흰색

                for(int i=0;i<board[x][y].size();i++) {
                    Horse h = board[x][y].remove(i);

                    int parent = 0;
                    if(board[x+dx][y+dy].size() > 0) {
                        parent = board[x+dx][y+dy].get(0).number;
                        h.parent = parent;
                    }

                    board[x+dx][y+dy].add(h);
                }

                if(board[x+dx][y+dy].size() >= 4) {
                    isFull = true;
                }
                break;

            }else if(nextColor == 1) { // 빨간색

                for(int i=board[x][y].size()-1;i>=0;i--) {
                    Horse h = board[x][y].remove(i);

                    int parent = 0;
                    if(board[x+dx][y+dy].size() > 0) {
                        parent = board[x+dx][y+dy].get(0).number;
                        h.parent = parent;
                    }

                    board[x+dx][y+dy].add(h);
                }

                if(board[x+dx][y+dy].size() >= 4) {
                    isFull = true;
                }
                break;

            }else { // 파란색
                dx *= -1;
                dy *= -1;

                if(x+dx > N || x+dx <= 0 || y+dy > N || y+dy <= 0) { // 방향 반대로 바꾸고 이동할려는 칸이 경계 밖이면
                    dx *= -1;
                    dy *= -1;

                    for(int i=0;i<board[x][y].size();i++) {
                        board[x][y].get(i).direction = dx + dy; // 방향 재설정
                    }
                    break;
                }

                if(arr[x+dx][y+dy] == 2) { // 방향 반대로 바꾸고 이동할려는 칸이 파란색이면

                    for(int i=0;i<board[x][y].size();i++) {
                        board[x][y].get(i).direction = dx + dy; // 방향 재설정
                    }
                    break;
                }

                nextColor = arr[x+dx][y+dy];

            }
        }
    }

}
