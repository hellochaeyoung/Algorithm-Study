package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr);

        long sum = 0; // 모든 학생이 자신의 예상 등수를 1등으로 예상한 경우 불만도 점수의 범위가 int형 범위를 벗어남
        for(int i=0;i<N;i++) {
            sum += Math.abs((i+1) - arr[i]);
        }

        System.out.println(sum);
    }
}
