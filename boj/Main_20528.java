package boj;

import java.io.*;
import java.util.*;

public class Main_20528 {

    static String[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = st.nextToken();
        }

        if(check()) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }

    }

    static boolean check() {

        for(int i=0;i<arr.length-1;i++) {
            int last = arr[i].charAt(arr[i].length()-1);
            int start = arr[i+1].charAt(0);

            if(last != start) {
                return false;
            }
        }

        return true;
    }
}
