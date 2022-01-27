package boj;

import java.io.*;
import java.util.*;

public class Main_1038 {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N <= 10) {
            System.out.println(N);
        }else if(N > 1022) {
            System.out.println(-1);
        }else {
            for(int i=0;i<10;i++) {
                find(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }

    // 단순 반복문으로 막힐 땐 재귀함수 사용하는 것 생각하기!
    static void find(long n, int index) {
        if(index > 10) {
            return;
        }

        list.add(n);
        for(int i=0;i< n%10; i++) {
            find((n*10)+i, index+1);
        }
    }
}
