package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이분 탐색 및 다익스트라
// 나중에 다시 풀어볼 것...
public class Main_1800 {

    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node n) {
            return this.weight > n.weight ? 1 : -1;
        }
    }

    static int N, P, K;
    static ArrayList<Node>[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;
        int answer = -1;
        map = new ArrayList[N+1];
        for(int i=1;i<=N;i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=0;i<P;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[s].add(new Node(v, w));
            map[v].add(new Node(s, w));
            right = Math.max(right, w);
        }

        while(left <= right) {
            int mid = (left + right) / 2;

            if(dijkstra(mid)) {
                right = mid - 1;
                answer = mid;
            }else {
                left = mid + 1;
            }
        }

        System.out.println(answer);

    }

    static boolean dijkstra(int max) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[N+1];
        for(int i=1;i<=N;i++) {
            dist[i] = Integer.MAX_VALUE; // 방문 노드 판단 여부로 쓰임
        }

        dist[1] = 0;
        queue.add(new Node(1,0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(Node next : map[node.end]) {
                if(dist[next.end] > node.weight + (next.weight > max ? 1 : 0)) {
                    dist[next.end] = node.weight + (next.weight > max ? 1 : 0);
                    queue.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist[N] <= K;
    }
}
