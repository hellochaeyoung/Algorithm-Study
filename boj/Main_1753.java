package boj;

import java.util.*;
import java.io.*;

public class Main_1753 {

    static int[][] node;
    static int[][] weight;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        node = new int[V+1][E+1];
        weight = new int[V+1][E+1];

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            node[u][v] = 1;
            weight[u][v] = w;
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

    static void findRoute(int k) {

    }

    static void getWeight(int u, int v) {

        if(node[u][v] != 0) {
            min = Math.min(min, weight[u][v]);
        }else {
            
        }
    }
}
