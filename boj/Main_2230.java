package boj;

import java.io.*;
import java.util.*;

public class Main_2230 {

    static int[] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        for(int i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        System.out.println(findMin(N, M));
    }

    static int findMin(int n, int m) {

        int min = Integer.MAX_VALUE;
        int i=0, j=0;


        // 투 포인터 알고리즘 : 1차원 배열에서 부분 배열 중 원소의 합이 M이 되는 경우의 수를 구할 때 사용되는 알고리즘
        // 각 포인터는 부분 배열의 처음과 끝을 가리킨다.
        while(i < n) {

            if(numbers[i] - numbers[j] < m) {
                i++; // ----->
                continue;
            }

            if(numbers[i] - numbers[j] == m) {
                min = numbers[i] - numbers[j];
                break;
            }

            min = Math.min(min, numbers[i] - numbers[j]);
            j++; // -----> 루프 돌 때 마다 i나 j 중 하나는 무조건 증가한다 -> 그래서 시간복잡도는 O(n)

        }


        // 이분 탐색
        /*
        int start=0, end = 0;
        for(int i=0;i<n;i++) {
            start = i;
            end = n;

            while(start < end) {
                int mid = (start + end) / 2;
                if(numbers[mid] - numbers[i] < m) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }

            if(end == n) {
                continue;
            }

            min = Math.min(min, numbers[end] - numbers[i]);

            if(min == m) {
                break;
            }


        }*/

        return min;
    }
}
