package boj;

import java.util.*;
import java.io.*;

public class Main_2661 {

    static int[] numbers = {1,2,3};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("");

    }

    static void dfs(String str) {

        if(str.length() == N) {
            System.out.println(str);
            System.exit(0);
            return;
        }

        for(int j=0;j<numbers.length;j++) {

            if(isRight(str + numbers[j])) {
                dfs(str+numbers[j]);
            }

        }
    }

    static boolean isRight(String str) {

        int len = str.length() / 2;
        for(int i=1;i<=len;i++) {
            if(str.substring(str.length() - i).equals(str.substring(str.length() - 2*i, str.length() - i))) {
                return false;
            }
        }

        return true;
    }
}
