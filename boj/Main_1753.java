package boj;

import java.util.*;
import java.io.*;

public class Main_1753 {

    static int V;
    static int E;
    static boolean[] visited;
    static int[][] weight;
    static int min = Integer.MAX_VALUE;
    static int INF = 10000000;
    static int d[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 노드의 수
        E = Integer.parseInt(st.nextToken()); // 간선의 수
        int K = Integer.parseInt(br.readLine());

        visited = new boolean[V+1];
        weight = new int[V+1][E+1];
        d = new int[V+1];

        //초기화
        for(int i=1;i<=V;i++) {
            for(int j=1;j<=E;j++) {
                if(i==j) {
                    weight[i][j] = 0;
                }else {
                    weight[i][j] = INF;
                }
            }
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            weight[u][v] = w;
            weight[v][u] = w;
        }

        dijkstra(K);
        for(int i=1;i<=d.length;i++) {
            System.out.println(d[i]);
        }
        /*
        for(int i=1;i<=V;i++) {
            for(int j=1;j<=E;j++) {
                System.out.print(node[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for(int i=1;i<=V;i++) {
            for(int j=1;j<=E;j++) {
                System.out.print(weight[i][j] + " ");
            }
            System.out.println();
        }
         */

    }

    static void dijkstra(int k) {

        for(int i=1;i<=V;i++) {
            d[i] = weight[k][i];
        }
        visited[k] = true;
        for(int i=0;i<V-2;i++) {
            int cur = getSmallIndex(k);
            visited[cur] = true;
            for(int j=1;j<=V;j++) {
                if(!visited[j]){
                    if(d[cur] + weight[k][j] < d[j]) {
                        d[j] = d[cur] + weight[k][j];
                    }
                }
            }
        }
    }

    static int getSmallIndex(int start) {
        int min = INF;
        int index = 0;
        for(int i=1;i<=V;i++) {
            if(weight[start][i] < min && !visited[i]) {
                index = i;
            }
        }

        return index;
    }
}
