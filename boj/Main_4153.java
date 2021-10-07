package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4153 {

    public static int a;
    public static int b;
    public static int c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0){
                break;
            }

            checkSize();

            checkRightAngle();

        }

    }

    public static void checkSize() {

        int temp = 0;

        if(a > c) {
            if(b > a) {
                temp = c;
                c = b;
                b = temp;
            }else {
                temp = a;
                a = c;
                c = temp;
            }
        }else if(b > c) {
            if(a > b) {
                temp = c;
                c = a;
                a = temp;
            }else {
                temp = b;
                b = c;
                c = temp;
            }
        }

    }

    public static void checkRightAngle() {

        int num = a*a + b*b;
        if(num == c*c) {
            print("right");
        }else {
            print("wrong");
        }
    }

    public static void print(String answer) {
        System.out.println(answer);
    }
}
