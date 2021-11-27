package boj;

import java.io.*;
import java.util.*;

// DP문제 : 중복되는 연산을 피하기 위한 기법
public class Main_2579 {

    static int stairs = 0;
    static int[] dp;
    static int[] scores;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairs = Integer.parseInt(br.readLine());

        dp = new int[301];
        scores = new int[301];

        for(int i=1;i<=stairs;i++) {
            int sc = Integer.parseInt(br.readLine());
            scores[i] = sc;
        }

        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        dp[3] = Math.max(scores[1]+scores[3], scores[2]+scores[3]);

        for(int i=4;i<=stairs;i++) {
            dp[i] = Math.max(dp[i-3]+scores[i]+scores[i-1], dp[i-2]+scores[i]);
        }

        System.out.println(dp[stairs]);
    }

}
