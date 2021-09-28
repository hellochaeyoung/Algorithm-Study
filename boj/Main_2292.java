package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int prev = 1;

        if(num == 1) {
            System.out.println("1");
            return;
        }
        int n=1;
        while(true) {
            int pNum = 6*n + prev;
            if(num <= pNum) {
                System.out.println(n+1);
                break;
            }else {
                prev = pNum;
            }
            n++;
        }

    }


}
