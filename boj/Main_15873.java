package boj;

import java.io.*;

public class Main_15873 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        int a = 0;
        int b = 0;
        int len = number.length();
        if(len == 2) {
            a = number.charAt(0) - '0'; // 아스키 코드 이용하여 문자 -> 숫자 변환
            b = number.charAt(1) - '0';
        }else {
            if(number.charAt(1) == '0') {
                a = Integer.parseInt(number.substring(0,2));
                b = Integer.parseInt(number.substring(2));
            }else {
                a = number.charAt(0) - '0';
                b = Integer.parseInt(number.substring(1));
            }
        }

        System.out.println(a+b);

    }
}
