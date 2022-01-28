package boj;

import java.io.*;
import java.util.*;

public class Main_15486 {

    static int N;
    static int[][] counsel;
    static int[] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        counsel = new int[N+2][2];
        dp = new int[N+2];

        for(int i=1;i<N+1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            counsel[i][0] = Integer.parseInt(st.nextToken());
            counsel[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N+1;i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
            int next = i + counsel[i][0];
            if(next < N+2){
                dp[next] = Math.max(dp[next], max+counsel[i][1]);
            }
        }

        max = Math.max(max, dp[N+1]);

        System.out.println(max);
    }

}
