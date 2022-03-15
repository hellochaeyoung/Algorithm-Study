package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1802 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            String str = br.readLine();
            if(check(str, 0, str.length()-1)) {
                sb.append("YES" + "\n");
            }else {
                sb.append("NO" + "\n");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }

    static boolean check(String str, int s, int e) {

        if(s >= e) return true;
        int m = s;
        int r = e;
        while(m < r) {
            if (str.charAt(m) == str.charAt(r)) {
                return false;
            }
            m++;
            r--;
        }

        return check(str, s, r-1);
    }
}
