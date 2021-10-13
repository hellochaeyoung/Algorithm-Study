package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Main_10837 {

    static int[][] input;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        input = new int[C][2];

        for(int i=0;i<C;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<C;i++) {
            if(isPossible(input[i][0], input[i][1])){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }

    }

    static boolean isPossible(int M, int N) {

        int gap = Math.abs(M-N);
        int leftRound = K - Math.max(M,N);

        if(M == N) {
            return true;
        }else if(M < N) { // 동수의 점수가 더 높을 경우, 최대 1점 차까지 가능
            if(gap - leftRound <= 1) {
                return true;
            }else {
                return false;
            }
        }else { // 영희의 점수가 더 높을 경우, 항상 영희가 더 먼저 시작하기 때문에 최대 2점 차까지 가능
            if(gap - leftRound <= 2) {
                return true;
            }else {
                return false;
            }
        }
    }


}
