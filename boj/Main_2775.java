package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[15][15];
        int sum = 0;

        for(int i=0;i<arr.length;i++) {
            for(int j=1;j<=arr.length - 1;j++) {
                if(i==0) {
                    arr[i][j] = j;
                }else {
                    sum += arr[i-1][j];
                    arr[i][j] = sum;
                }
            }
            sum = 0;
        }

        /*
        for(int i=1;i<arr.length;i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        for(int i=1;i<arr.length;i++) {
           for(int j=2;j<arr.length;j++) {
               arr[i][j] = arr[i][j-1] + arr[i-1][j];
           }
        }
         */

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(arr[k][n]);
        }
    }

}


