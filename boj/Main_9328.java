package boj;

import java.io.*;
import java.util.*;

public class Main_9328 {

    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int h,w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int count = 0;

    static ArrayList<Node>[] doors;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(--t >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h+2][w+2]; ////////////
            visited = new boolean[h+2][w+2]; ////////////
            keys = new boolean[26];

            doors = new ArrayList[26];
            for(int i=0;i<26;i++) {
                doors[i] = new ArrayList<>();
            }

            for(int i=0;i<h+2;i++) {
                for(int j=0;j<w+2;j++) {
                    map[i][j] = '.';   //////////////
                }
            }

            for(int i=1;i<=h;i++) {
                String str = br.readLine();
                for(int j=1;j<=w;j++) {
                    map[i][j] = str.charAt(j-1);
                }
            }

            String key = br.readLine();
            if(!key.equals("0")) {
                for(int i=0;i<key.length();i++) {
                    int index = key.charAt(i) - 97;
                    keys[index] = true;
                }
            }

            bfs();

            System.out.println(count);
            count = 0;
        }

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0,0));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i=0;i<4;i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= h+2 || ny < 0 || ny >= w+2) {
                    continue;
                }

                if(map[nx][ny] == '*') {
                    continue;
                }

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int ch = map[nx][ny];
                    if(ch >= 65 && ch <= 90) { // 대문자, 문 발견 시
                        int index = ch - 65;

                        if(keys[index]) {
                            q.offer(new Node(nx, ny));
                        }else {
                            visited[nx][ny] = false;
                            doors[index].add(new Node(nx, ny)); // 문 위치 저장
                        }
                    }else if(ch >= 97 && ch <= 122) { // 소문자, 열쇠 발견 시
                        int index = ch - 97;
                        keys[index] = true;
                        q.offer(new Node(nx, ny));
                    }else {
                        if(map[nx][ny] == '.') {
                            q.offer(new Node(nx, ny));
                        }else if(map[nx][ny] == '$') {
                            count++;
                            q.offer(new Node(nx, ny)); //////////
                        }
                    }

                    ///////////////////////////////////////////////
                    for(int j=0;j<26;j++) {
                        if(doors[j].size() != 0 && keys[j]) {
                            for(int z=0;z<doors[j].size();z++) {
                                Node nd = doors[j].get(z);
                                visited[nd.x][nd.y] = true;
                                q.offer(nd);
                            }

                        }
                    }
                }
            }
        }
    }
}
