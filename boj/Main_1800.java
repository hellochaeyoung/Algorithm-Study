package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1800 {

    static int N, P, K;
    static int[][] graph;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<P;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[s][v] = w;
            graph[v][s] = w;
        }

        visited[1] = true;
        dfs(1);

        if(min > 0) {
            System.out.println(min);
        }else {
            System.out.println(-1);
        }

    }

    static void dfs(int start) {

        if(start == N) {
            ArrayList<Integer> tmpList = (ArrayList<Integer>) list.clone();

            Collections.sort(tmpList, Collections.reverseOrder());
            for(int i=0;i<K;i++) {
                tmpList.remove(0);
            }

            if(tmpList.size() > 0) {
                min = Math.min(min, tmpList.get(0));
            }
            return;
        }

        for(int i=2;i<=N;i++) {
            if(graph[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                list.add(graph[start][i]);
                dfs(i);

                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
