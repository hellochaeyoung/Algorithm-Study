package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        boolean isPrime = true;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(st.nextToken());

            if(n == 1) {
                continue;
            }
            for(int j=2;j<=Math.sqrt(n);j++) {
                if(n % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            /*
            if( n == 2 || n == 3 || n == 5 || n == 7) {
                isPrime = true;
            }else {
                for(int j=2;j<n;j++) {
                    if(n % j == 0){
                        isPrime = false;
                        break;
                    }else {
                        isPrime = true;
                    }
                }
            }
*/

            if(isPrime){
                count++;
            }
            isPrime = true;
        }
        System.out.println(count);
    }


}
