package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Check1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        if(A > B) {
            int temp = A;
            A = B;
            B = temp;
        }

        int start = 1;
        int end = N;

        while(true) {
            int mid = start + (end - start) / 2;
            if(A <= mid && B > mid) {
                System.out.println((int) log(end - start + 1, 2)) ;
                break;
            }else if(A > mid && B > mid) {
                start = mid + 1;
            }else if(A <= mid && B <= mid) {
                end = mid;
            }
        }
    }

    static double log(double x, double base) {
        return Math.log(x) / Math.log(base);
    }
}
