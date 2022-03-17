package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] c = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];

            dp[0] = 1;
            for(int i=0;i<N;i++) {
                for(int j=c[i];j<=M;j++) {
                    dp[j] = dp[j] + dp[j-c[i]];
                }
            }

            list.add(dp[M]);
        }

        for(int n : list) {
            System.out.println(n);
        }
    }

}
