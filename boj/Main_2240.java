package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2240 {

    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        dp = new int[T+1][3][W+1];

        int n = Integer.parseInt(br.readLine());

        // 자두가 처음에는 항상 1번 나무에 위치해있기 때문에
        if(n == 1) {
            dp[1][1][0] = 1;
            dp[1][2][1] = 0;
        }else if(n == 2) {
            dp[1][1][0] = 0;
            dp[1][2][1] = 1;
        }

        for(int t=2;t<=T;t++) {
            n = Integer.parseInt(br.readLine());

            if(n == 1) {
                //0번째 이동한 경우 비교값이 없으므로 이전 번째 값으로 따로 처리
                dp[t][1][0] = dp[t-1][1][0] + 1;
                dp[t][2][0] = dp[t-1][2][0];

                for(int w=1;w<=W;w++) {
                    dp[t][1][w] = Math.max(dp[t-1][1][w], dp[t-1][2][w-1]) + 1;
                    dp[t][2][w] = Math.max(dp[t-1][2][w-1], dp[t-1][2][w]);
                }
            }

            else if(n == 2) {
                dp[t][1][0] = dp[t-1][1][0];
                dp[t][2][0] = dp[t-1][2][0] + 1;

                for(int w=1;w<=W;w++) {
                    dp[t][1][w] = Math.max(dp[t-1][1][w], dp[t-1][2][w-1]);
                    dp[t][2][w] = Math.max(dp[t-1][1][w-1], dp[t-1][2][w]) + 1;
                }
            }
        }

        int max = 0;
        for(int w=0;w<=W;w++) {
            max = Math.max(max, Math.max(dp[T][1][w], dp[T][2][w]));
        }

        System.out.println(max);
    }
}
