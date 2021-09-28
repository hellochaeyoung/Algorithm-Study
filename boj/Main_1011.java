package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1011 {

    public static int restDistance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y-x;
            int count = 0;

            int max = (int)Math.sqrt(distance);

            if(max == Math.sqrt(distance)) {
                count = 2*max - 1;
            }else if(distance <= max * max + max) {
                count = 2*max;
            }else {
                count = 2*max + 1;
            }

            System.out.println(count);
        }


    }



}
