package boj;

import java.util.*;
import java.io.*;

class Edge {
    int start, end, weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
public class Main_1197 {

    static int[] parent;
    static PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> (int)(o1.weight - o2.weight));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1;i<=V;i++) {
            parent[i] = i;
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Edge(a,b,c));
        }

        System.out.println(kruskal());
    }

    static int kruskal() {

        int minWeight = 0;

        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            int start = edge.start;
            int end = edge.end;

            if(!isSameParent(start, end)) {
                union(start, end);

                minWeight += edge.weight;
            }
        }

        return minWeight;

    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }else {
            return parent[x] = find(parent[x]);
        }
    }

    static boolean isSameParent(int x, int y) {

        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }else {
            return false;
        }
    }

    static void union(int x, int y) {

        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) {
                parent[y] = x;
            }else {
                parent[x] = y;
            }
        }
    }
}
