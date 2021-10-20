package boj;

import java.util.*;
import java.io.*;

public class Main_14719 {

    static int[] arr;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getRain());

    }

    static int getRain() {

        int left = arr[0];
        int right = 0;
        int rain = 0;
        for(int i=1;i<arr.length-1;i++) {
            right = arr[i];
            for(int j=0;j<i;j++) {
                if(arr[i] >= left) {
                    left = arr[i];
                }
            }

            for(int z=i;z<arr.length;z++) {
                if(arr[z] >= right) {
                    right = arr[z];
                }
            }

            if(left > right) {
                rain += right - arr[i];
            }else {
                rain += left - arr[i];
            }
        }

        return rain;

    }
}