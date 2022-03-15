package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2885 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int i = 1;
        while(i < k) {
            i *= 2;
        }

        int num = i;
        int cnt = 0;
        while(k > 0) {
            if(k < i) { // 횟수를 세는게 가장 중요하다는 점.
                i /= 2;
                cnt++;
            }else {
                k -= i;
            }

        }

        System.out.println(num + " " + cnt);
    }
}
