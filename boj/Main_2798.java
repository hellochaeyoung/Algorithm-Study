package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2798 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = getSum(N,M);

        print(sum);
    }

    static int getSum(int n, int m) {

        int sum = 0;
        int now = 0;

        for(int i=0;i<n-2;i++) {
            for(int j = i+1; j<n-1;j++) {
                for(int z = j+1; z<n;z++) {
                    sum = arr[i] + arr[j] + arr[z];

                    if(sum == m) {
                        now = sum;
                        break;
                    }

                    if(sum <= m && sum > now) {
                        now = sum;
                    }
                }
            }
        }

        return now;
    }

    static void print(int s) {
        System.out.println(s);
    }
}
