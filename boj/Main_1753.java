package boj;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main_1753 {


    static int V,E,K;
    static List<Node>[] list;
    static int INF = 10000000;
    static int dist[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 노드의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        dist = new int[V+1];

        Arrays.fill(dist, INF);

        for(int i=1;i<=V;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=V;i++) {
            if(dist[i] == INF){
                sb.append("INF\n");
            }else {
                sb.append(dist[i] + "\n");
            }
        }

        System.out.println(sb);

    }

    static void dijkstra(int k) {

        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        q.add(new Node(k, 0));
        dist[k] = 0;

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.end;

            if(check[cur]) {
                continue;
            }
            check[cur] = true;

            for(Node node : list[cur]) {
                if(dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }

    }

}
