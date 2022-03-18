package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] len = new int[N-1];
        int[] price = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N-1;i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];

        long totalPrice = 0;
        long temp = len[0];
        int min = price[0];

        for(int i=1;i<N;i++) {
            if(!visited[i]) {
                if(i == N-1) {
                    totalPrice += temp * min;
                }else {
                    if(min > price[i]) {
                        totalPrice += temp * min;
                        min = price[i];
                        temp = len[i];
                    }else {
                        temp += len[i];
                    }
                    visited[i] = true;
                }
            }
        }

        System.out.println(totalPrice);
    }
}
