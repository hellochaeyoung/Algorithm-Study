package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3584 {

    static ArrayList<Integer>[] list;
    static int[] parent, depth;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());

            parent = new int[N+1];
            depth = new int[N+1];
            list = new ArrayList[N+1];
            for(int z=1;z<N+1;z++) {
                list[z] = new ArrayList<>();
            }

            boolean[] check = new boolean[N+1];
            Arrays.fill(check, true);
            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                check[b] = false;
            }

            int root = 0;
            for(int t=1;t<N+1;t++) {
                if(check[t]) {
                    root = t;
                    break;
                }
            }

            init(root, 1, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a,b));

        }
    }

    static void init(int cur, int h, int pa) {
        depth[cur] = h;
        parent[cur] = pa;
        for(int n : list[cur]) {
            if(n != pa) {
                init(n, h+1, cur);
            }
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        while(ah > bh) {
            a = parent[a];
            ah--;
        }

        while(bh > ah) {
            b = parent[b];
            bh--;
        }

        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
