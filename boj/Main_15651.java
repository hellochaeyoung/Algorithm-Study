package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N,M,0);

        System.out.println(sb);
    }

    static void dfs(int n, int m, int depth) {

        if(depth == m) {
            for(int num : arr) {
                sb.append(num + " "); // 출력이 반복된다면 StringBuilder를 사용해 한 번에 출력하는게 메모리, 속도 측면에서 유리하다.
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++) {
            arr[depth] = i+1;

            dfs(n,m,depth+1);
        }
        return;
    }
}
