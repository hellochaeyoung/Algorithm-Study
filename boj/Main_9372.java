package boj;

import java.io.*;
import java.util.*;

public class Main_9372 {

    static int N,M;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int n=1;n<=N;n++) {
                list[n] = new ArrayList<>();
            }

            for(int j=0;j<M;j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(end);
                list[end].add(start);
            }

            find();
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
}
