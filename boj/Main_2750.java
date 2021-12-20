package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /* 1. 라이브러리 사용
        Arrays.sort(arr);

        for(int i : arr) {
            System.out.println(i);
        }
       */

        // 2. 직접 구현(버블 정렬)
        for(int i=1;i<arr.length;i++) {

            for(int j=0;j<arr.length - i;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }

        for(int i : arr) {
            System.out.println(i);
        }

        // 큰 차이는 없었으나 라이브러리 정렬 함수를 사용하는 것이 메모리 측면에서나 속도 면에서 더 우수했다.

    }
}
