package boj;

import java.io.*;
import java.util.*;

public class Main_15591 {

    static ArrayList<int[]>[] list;
    static int N, Q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            list[n1].add(new int[] {n2, usado});
            list[n2].add(new int[] {n1, usado});

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            sb.append(findVideo(K, V) + "\n");
        }

        System.out.println(sb);
    }

    static int findVideo(int k, int v) {

        boolean[] visited = new boolean[N+1];
        visited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(v);

        int count = 0;
        while(!q.isEmpty()) {
            int now = q.poll();

            for(int[] arr : list[now]) {
                if(!visited[arr[0]] && arr[1] >= k) {
                    q.add(arr[0]);
                    visited[arr[0]] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
