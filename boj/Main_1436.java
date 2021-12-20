package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int n = 1;
        int i = 0;
        int temp = 0;

        // 이 문제의 핵심, 큰 자릿수 부터 조건 따질것!!
        while(true) {

            if((i % 10000) / 10 == 666 && i % 10 != 6) {
                for(int j=0;i<1000;j++) {
                    if(n == N) {
                        System.out.println(i * 1000 + j);
                        return;
                    }
                    n++;
                }
            }

            else if(i % 1000 == 666){
                for(int j=0;j<1000;j++) {
                    if(n == N) {
                        System.out.println(i * 1000 + j);
                        return;
                    }
                    n++;
                }
            }

            else if(i % 100 == 66) {
                temp = 600;
                for(int j=0;j<100;j++) {
                    if(n == N) {
                        System.out.println(i * 1000 + temp + j);
                        return;
                    }
                    n++;
                }
            }

            else if (i % 10 == 6) {
                temp = 660;
                for(int j=0;j<10;j++) {
                    if(n == N) {
                        System.out.println(i * 1000 + temp + j);
                        return;
                    }
                    n++;
                }

            }

            else {
                temp = 666;
                if(n == N) {
                    System.out.println(i * 1000 + temp);
                    return;
                }
                n++;
            }

            i++;
        }


    }
}
