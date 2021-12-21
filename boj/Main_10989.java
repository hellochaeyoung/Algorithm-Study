package boj;

import java.io.*;
import java.util.*;

public class Main_10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for(int i=0;i<N;i++) {
            int index = Integer.parseInt(br.readLine());
            arr[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i];j++) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
