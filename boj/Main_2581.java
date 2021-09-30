package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2581 {

    public static boolean[] isNotPrime = new boolean[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        isCheckPrime(N);

        int sum = getSum(M,N);
        int min = getMin(M,N);

        printSumAndMin(sum, min);

    }

    public static void isCheckPrime(int end) {
        for(int i = 2;i<Math.sqrt(end);i++) {
            for(int j = i*i; j< end + 1; j = j+i){
                isNotPrime[j] = true; // 소수가 아님
            }
        }
    }

    public static int getSum(int start, int end) {
        int sum = 0;

        for(int i = start;i<end+1;i++) {
            if(!isNotPrime[i]){
                sum += i;
            }
        }

        return sum;
    }

    public static int getMin(int start, int end) {
        int min = 0;
        for(int i = start; i < end+1; i++) {
            if(!isNotPrime[i]) {
                min = i;
                break;
            }
        }

        return min;
    }

    public static void printSumAndMin(int sum, int min) {

        if(sum == 0){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
