package boj;

import java.util.*;
import java.io.*;

public class Main_16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        int cnt = 1;

        while(true) {

            if( B.equals(A)) {
                break;
            }

            if( B < A ) {
                cnt = -1;
                break;
            }

            String str = String.valueOf(B);

            if(str.charAt(str.length()-1) != '1' && B % 2 != 0) {
                cnt = -1;
                break;
            }

            if(str.charAt(str.length()-1) == '1') {
                str = str.substring(0, str.length()-1);
                B = Long.parseLong(str);
            }else {
                B /= 2;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
