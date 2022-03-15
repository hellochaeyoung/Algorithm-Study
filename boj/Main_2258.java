package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = p;

        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            }

            return Integer.compare(o1[1], o2[1]);
        });

        int totalWeight = 0;
        int totalPrice = -1;
        boolean possible = false;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++) {

            totalWeight += arr[i][0];

            if(i > 0 && arr[i-1][0] == arr[i][0]) {
                totalPrice += arr[i][1];
            }else {
                totalPrice = arr[i][1];
            }

            if(totalWeight >= M) {
                possible = true;

                // 목표 무게 넘겼더라도 가격이 더 싸면 사기 때문에에
                min = Math.min(min, totalPrice);
            }
        }

       System.out.println(possible ? min : -1);
    }


}
