package boj;

import java.util.*;
import java.io.*;

public class Main_1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }

        HashSet<String> set = new HashSet<>(Arrays.asList(arr));
        String[] resultArr = set.toArray(new String[0]);

        Arrays.sort(resultArr, (String s1, String s2) -> {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }else {
                return s1.length() - s2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : resultArr) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
