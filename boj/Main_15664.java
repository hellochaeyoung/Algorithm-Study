package boj;

import java.util.*;
import java.io.*;

public class Main_15664 {

    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0;i<N;i++) {
            dfs(i,0);
        }
        
        for(String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int start, int depth) {

        if(depth == M) {
            String str = "";
            for(int i=0;i<M;i++) {
                str += answer[i] + " ";
            }
            set.add(str);
            return;
        }

        for(int i=start;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(i+1,depth+1);

                visited[i] = false;
            }
        }

        return;
    }
}
