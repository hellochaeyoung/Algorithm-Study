package boj;

import java.io.*;
import java.util.*;

public class Main_11478 {

    static String S;
    //static char[] input;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();


        for(int i=1;i<=S.length();i++) {
            getChar(i);
        }

        System.out.println(map.size());

    }

    static void getChar(int end) {
        int i=0;
        while(i + end <= S.length()) {
            String now = S.substring(i, i+end);
            map.put(now, map.getOrDefault(now, 0) +1);
            i++;

        }
    }

}
