package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soma2_1 {

    static int N, M, K;
    static int[][] arr;
    static boolean[] visited;
    static boolean[] v;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[M];
        v = new boolean[M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);

        System.out.println(max);
    }

    static void dfs(int start, int cnt, int depth) {

        if(cnt == K || depth == M) {
            int answer = check();
            max = Math.max(max, answer);
            return;
        }

        for(int i=start;i<M;i++) {
            if(!visited[i]) {
                visited[i] = true;

                v[i] = true; // 여러 메뉴를 지울 수 있기 때문에 경우에 따라 배열에 표시
                dfs(start++, cnt+1, depth+1);

                v[i] = false;
            }
        }
    }

    static int check() {

        int count = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(!v[j]) {
                    if(arr[i][j] >= 5) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}
