package boj;

import java.io.*;


public class Main_11653 {

    public static boolean[] isNotPrime;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            return;
        }

        isNotPrime  = new boolean[n+1];

        checkIsPrime(n);

        int num = 0;
        while(true) {

            num = getNumbers(n);
            if(num == 1) {
                break;
            }
            n = num;
        }



    }

    public static void checkIsPrime(int n) {

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i=2;i<Math.sqrt(n);i++) {
            for(int j = i*i ; j < n+1;j = j+i ) {
                if(!isNotPrime[j]) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public static int getNumbers(int n) {

        for(int i=2;i < n+1;i++) {
            if(!isNotPrime[i]) {
                if(n % i == 0) {
                    print(i);
                    return (n/i);
                }
            }
        }

        return n;
    }

    public static void print(int n) {
        System.out.println(n);
    }
}
