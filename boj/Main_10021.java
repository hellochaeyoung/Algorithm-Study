package boj;

import java.io.*;
import java.util.*;

public class Main_10021 {

    static int N,C;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        graph = new ArrayList[N];
        visited = new boolean[N];
        dist = new int[N];

        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        makeGraph();

        System.out.println(prim());
    }

    static void makeGraph() {

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                double xDistance = Math.pow((arr[i][0] - arr[j][0]), 2);
                double yDistance = Math.pow((arr[i][1] - arr[j][1]), 2);

                int distance = (int)(xDistance + yDistance);

                if(distance >= C) {
                    graph[i].add(new int[] {j, distance});
                    graph[j].add(new int[] {i, distance});
                }
            }
        }
    }

    static int prim() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        int weight = 0;
        int cnt = 0;
        queue.add(0);
        dist[0] = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(!visited[node]) {
                visited[node] = true;
                cnt++;
                for(int[] arr : graph[node]) {
                    if(dist[arr[0]] >= dist[node] + arr[1]) {
                        dist[arr[0]] = dist[node] + arr[1];
                        weight += dist[arr[0]];
                        queue.add(arr[0]);
                    }
                }
            }
        }

        if(cnt < N-1) {
            return -1;
        }

        return weight;

    }


}
