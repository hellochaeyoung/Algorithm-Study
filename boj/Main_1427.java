package boj;

import java.io.*;
import java.util.*;

public class Main_1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        Integer[] arr = new Integer[N.length()];
        for(int i=0;i<N.length();i++) {
            arr[i] = N.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(n);
        }

        System.out.println(sb);
    }
}
