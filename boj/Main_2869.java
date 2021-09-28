package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int afternoon = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int tree = Integer.parseInt(st.nextToken());

        int oneDay = afternoon - night;
        int start = tree - afternoon;

        int days = start / oneDay;

        if(start % oneDay > 0) {
            days = days + 1;
        }

        System.out.println(days + 1);

    }


}
