package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = s.split("-");

        int sum = Integer.MAX_VALUE;

        for(String st : arr) {
            String[] temp = st.split("\\+");

            int ss = 0;
            for(String str : temp) {
                ss += Integer.parseInt(str);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = ss;
            }else {
                sum -= ss;
            }
        }

        System.out.println(sum);
    }
}
