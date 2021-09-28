package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        String[] arr = new String[t];
        int i = 0;
        int room = 0;
        int floor = 0;

        while(i < t) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(n % h == 0) {
                room = n / h;
                floor = h * 100;
            }else {
                room = n / h + 1;
                floor = (n % h) * 100;
            }

            System.out.println(floor + room);

            i++;
        }

    }

}
