package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] k = new int[12];
        Arrays.fill(k, 1);

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++) {
            int idx = Integer.parseInt(st.nextToken());
            k[idx]--;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++) {
            int idx = Integer.parseInt(st.nextToken());
            k[idx]++;
        }

        for (int i=1;i<=N;i++) {
            if(k[i] == 2) {
                if(i == 1) {
                    if(k[i+1] == 0) {
                        k[i+1] = 1;
                        k[i] = 1;
                    }
                }

                else if(i==N) {
                    if(k[i-1] == 0) {
                        k[i-1] = 1;
                        k[i] = 1;
                    }
                }

                else {
                    if((k[i-1] == 0 && k[i+1] == 0) || (k[i-1] == 0 && k[i+1] >= 1)) {
                        k[i-1] = 1;
                        k[i] = 1;
                    }

                    else if(k[i-1] >= 1 && k[i+1] == 0) {
                        k[i+1] = 1;
                        k[i] = 1;
                    }
                }
            }

        }

        for(int i=1;i<=N;i++) {
            if(k[i] == 0) answer++;
        }

        System.out.println(answer);

    }

}
