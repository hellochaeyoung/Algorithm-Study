package boj;

import java.io.*;
import java.util.*;

public class Main_9372 {

    static int N,M;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    static int[] parent;
    static int edge = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            visited = new boolean[N+1];

            parent = new int[N+1];

            for(int n=1;n<=N;n++) {
                list[n] = new ArrayList<>();
                parent[n] = n;
            }

            for(int j=0;j<M;j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(end);
                list[end].add(start);

                // kruskal
                kruskal(start, end);
            }

            find();

            System.out.println(edge);
            edge = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : answer) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }

    static void find() {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {

            if(cnt == N-1) {
                answer.add(cnt);
                break;
            }

            int now = queue.poll();

            for(int i : list[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    cnt++;
                    queue.add(i);
                }
            }

        }
    }

    static void kruskal(int u, int v) {

        for(int i=0;i<N;i++) {

            if(!isSameParent(u,v)) {
                edge++;

                union(u,v);
            }
        }

    }

    static boolean isSameParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if(x == y) {
            return true;
        }else{
            return false;
        }
    }

    static int findParent(int x) {

        if(x == parent[x]) {
            return x;
        }else {
            return parent[x] = findParent(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if(x != y) {
            if(x < y) {
                parent[y] = x;
            }else {
                parent[x] = y;
            }
        }
    }
}
