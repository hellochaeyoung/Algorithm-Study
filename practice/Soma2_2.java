package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soma2_2 {

    static int N, M, K;
    static long[] score;
    static int[][] friend;
    static long sum = 0;
    static int cnt = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new long[N+1];
        friend = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            score[p] = s;
        }

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        for(int i=1;i<N+1;i++) {
            if(score[i] == 0) {
                find(i);

                if(sum != 0 && cnt != 0) {
                    score[i] = sum / cnt;
                    sum = 0;
                    cnt = 0;
                }
            }
        }

        long total = 0;
        int c = 0;
        for(int i=1;i<N+1;i++) {
            if(score[i] != 0) {
                total += score[i];
                c++;
            }
        }

        double answer = (double) total / c;

        System.out.printf("%.2f", answer);
    }

    static void find(int n) {

        for(int i=1;i<N+1;i++) {
            if(friend[n][i] == 1 && !visited[n][i]) { // 서로 이어진 친구관계에 의해 무한루프 돌 가능성 있기 때문에 방문 체크하여 방지
                if(score[i] != 0) {
                    visited[n][i] = true;
                    visited[i][n] = true;
                    sum += score[i];
                    cnt++;
                }

                find(i);
            }
        }
    }
}
