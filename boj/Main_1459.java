package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1459 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());
        long s = Integer.parseInt(st.nextToken());

        long min;
        if(2*w < s) {
            min = (x + y) * w;
        }else if(2*w > 2*s) {
            if((x+y) % 2 == 0) {
                min = Math.max(x, y) * s;
            }else {
                min = (Math.max(x, y) - 1) * s;
                min += w;
            }
        }else {
            if(x == y) {
                min = s*x;
            }else {
                min = Math.min(x*s, y*s);
                min += Math.abs(x - y) *w;
            }
        }

        System.out.println(min);
    }

}
