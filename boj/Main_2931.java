package boj;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main_2931 {

    static class Node {
        int x, y, dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static char[] chArr = {'|', '-', '+', '1', '2', '3', '4'};
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static Point M,Z,tmp;
    static List<Point> list = new ArrayList<>();

    //서, 남, 동, 북
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                char ch = str.charAt(j);
                if(ch == 'M') {
                    M = new Point(j,i);
                }else if(ch == 'Z') {
                    Z = new Point(j,i);
                }

                if(ch != '.' && ch != 'M' && ch != 'Z') {
                    list.add(new Point(j,i));
                }

                map[i][j] = ch;
            }
        }

        bfs();

        Point first = new Point(tmp);

        first.x = tmp.x;
        first.y = tmp.y;

        for(int i=0;i<7;i++) {
            map[first.y][first.x] = chArr[i];
            visited = new boolean[R][C];
            Point second;
            bfs();
            second = new Point(tmp);
            if(second.x == -1 && second.y == -1) {
                if(check()) {
                    System.out.println((first.y+1) + " " + (first.x+1) + " " + map[first.y][first.x]);
                    return;
                }
            }
        }

    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        boolean isTrue = false;
        queue.add(new Node(M.x, M.y, 0));
        while(!queue.isEmpty()) {

            if(isTrue) {
                break;
            }

            Node n = queue.poll();

            if(map[n.y][n.x] == 'M') {
                for(int i=0;i<4;i++) {
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];

                    if(nx < 0 || nx >= C || ny < 0 || ny >= R) {
                        continue;
                    }

                    if(map[ny][nx] == 'Z') {
                        continue;
                    }

                    if(map[ny][nx] != '.') {
                        int dir = getDir(i, map[ny][nx]);
                        if(dir != -1) {
                            queue.add(new Node(nx, ny, dir));
                            if(!visited[ny][nx]) {
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }

                if(queue.size() == 0) {
                    for(int i=0;i<4;i++) {

                        if(isTrue) {
                            break;
                        }

                        int nx = n.x + dx[i];
                        int ny = n.y + dy[i];

                        if(nx < 0 || nx >= C || ny < 0 || ny >= R) {
                            continue;
                        }

                        for(int j=0;j<7;j++) {
                            visited = new boolean[R][C];
                            map[ny][nx] = chArr[j];

                            bfs();
                            if(tmp.x == -1 && tmp.y == -1) {
                                if(check()) {
                                    isTrue = true;
                                    System.out.println((n.y+1) + " " + (n.x+1) + " " + map[n.y][n.x]);
                                    return;
                                }
                            }
                            map[ny][nx] = '.';
                        }
                    }
                }
            }else {
                int nx = n.x + dx[n.dir];
                int ny = n.y + dy[n.dir];

                if(nx < 0 || nx >= C || ny < 0 || ny >= R) {
                    continue;
                }

                if(map[ny][nx] == '.') {
                    tmp = new Point(nx, ny);
                    return;
                }else if(map[ny][nx] == 'Z') {
                    tmp = new Point(-1,-1);
                    return;
                }

                int dir = getDir(n.dir, map[ny][nx]);
                if(dir == -1) {
                    tmp = new Point(nx, ny);
                    return;
                }
                if(!visited[ny][nx]) {
                    visited[ny][nx] = true;
                }

                queue.add(new Node(nx, ny, dir));
            }
        }
    }

    static int getDir(int dir, char ch) {

        int d = -1;
        if(ch == '|') {
            if(dir == 0 || dir == 2) {
                d = dir;
            }
        }else if(ch == '-') {
            if(dir == 1 || dir ==3) {
                d = dir;
            }
        }else if(ch == '+') {
            d = dir;
        }else if(ch == '1') {
            if(dir == 3) {
                d = 2;
            }else if(dir == 0) {
                d = 1;
            }
        }else if(ch == '2') {
            if(dir == 3) {
                d = 0;
            }else if(dir == 2) {
                d = 1;
            }
        }else if(ch == '3') {
            if(dir == 1) {
                d = 0;
            }else if(dir == 2) {
                d = 3;
            }
        }else if(ch == '4') {
            if(dir == 1) {
                d = 2;
            }else if(dir == 0) {
                d = 3;
            }
        }
        return d;
    }

    static boolean check() {
        for(int i=0;i<list.size();i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;

            if(!visited[y][x]) {
                return false;
            }
        }

        return true;
    }
}
