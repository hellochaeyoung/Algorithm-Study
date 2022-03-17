package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;


        for(int i=0;i<n;i++) {
            for(int j=arr[i];j<=k;j++) {
                dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
            }
        }

        if(dp[k] == 10001) {
            System.out.println(-1);
        }else {
            System.out.println(dp[k]);
        }
    }
}
