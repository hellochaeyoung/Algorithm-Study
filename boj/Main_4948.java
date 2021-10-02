package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4948 {

    public static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        while(true) {


            int start = Integer.parseInt(br.readLine());

            if(start == 0) {
                break;
            }

            int end = 2*start;
            isNotPrime = new boolean[end+1];

            checkIsPrime(end);

            getCountOfPrime(start, end);
        }


    }

    public static void checkIsPrime(int end) {

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i=2;i<=Math.sqrt(end);i++) {
            for(int j=i*i; j< end+1; j += i) {
                if(!isNotPrime[j]) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public static void getCountOfPrime(int start, int end) {
        int count = 0;
        for(int i=start+1;i<=end;i++) {
            if(!isNotPrime[i]){
                count++;
            }
        }
        printCount(count);
    }

    public static void printCount(int count) {
        System.out.println(count);
    }
}
