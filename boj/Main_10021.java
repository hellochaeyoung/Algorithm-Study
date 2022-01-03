package boj;

import java.io.*;
import java.util.*;


public class Main_10021 {

    static class Node {

        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static int N,C;
    static int[][] arr;
    static int[] parent;

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] minWeight;

    static PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> (int)(o1.weight - o2.weight));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        parent = new int[N];

        graph = new ArrayList[N];
        visited = new boolean[N];
        minWeight = new int[N];

        for(int i=0;i<N;i++) {
            parent[i] = i;
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        getDistance();

        System.out.println(kruskal());

        System.out.println(prim());
    }

    static void getDistance() {

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                double xDistance = Math.pow((arr[i][0] - arr[j][0]), 2);
                double yDistance = Math.pow((arr[i][1] - arr[j][1]), 2);

                int distance = (int)(xDistance + yDistance);

                if(distance >= C) {
                    queue.add(new Node(i, j, distance));

                    graph[i].add(new Node(i,j,distance));
                    graph[j].add(new Node(j,i,distance));
                }
            }
        }
    }

    static int kruskal() {

        int weight = 0;
        int cnt = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.start;
            int y = node.end;

            if(!isSameParent(x,y)) {
                weight += node.weight;
                cnt++;
                union(x,y);
            }

        }

        if(cnt != N-1) {
            return -1;
        }

        return weight;

    }

    static int prim() {

        Arrays.fill(minWeight, Integer.MAX_VALUE);

        int cnt = 0;
        int sum = 0;
        minWeight[0] = 0;

        for(int i=0;i<N;i++) {
            int u = -1;
            for(int j=0;j<N;j++) {
                if(!visited[j] && ((u == -1) || minWeight[u] > minWeight[j])) {
                    u = j;
                }
            }
            sum += minWeight[u];
            visited[u] = true;

            for(int z=0;z<graph[u].size();z++) {
                int end = graph[u].get(z).end;
                int weight = graph[u].get(z).weight;
                if(!visited[end] && minWeight[end] > weight) {
                    minWeight[end] = weight;
                }
            }
        }

        for(int n : minWeight) {
            if(n == Integer.MAX_VALUE) {
                return -1;
            }
        }

        return sum;
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }else {
            return parent[x] = find(parent[x]);
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

    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }else {
            return false;
        }
    }
}
