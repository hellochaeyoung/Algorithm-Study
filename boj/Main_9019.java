package boj;

import java.util.*;
import java.io.*;

public class Main_9019 {

    static ArrayList<String> list = new ArrayList<>();
    static String[] arr = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());


        }
    }

    static void find(int a, int b) {

        while(true) {

            // 한 명령어를 계속 이어서 할 것인지
            // 명령어를 한 번 씩 돌아가면서 탐색할 것인지
            for(String s : arr) {
                int result = calc(s, a);

                if(result == b) {
                    list.add(s);
                    break;
                }
            }
        }

    }

    static int calc(String s, int n) {

        int result = 0;
        String str = String.valueOf(n);
        switch (s) {
            case "D" :
                result = n*n;
                if(result > 9999) {
                    result = result % 1000;
                }
                break;
            case "S" :
                result = n-1;
                if(result == 0) {
                    result = 9999;
                }
                break;
            case "L" :
                String first = str.substring(0,1);
                result = Integer.parseInt(str.substring(1) + first);
                break;
            case "R" :
                String last = str.substring(str.length()-1);
                result = Integer.parseInt(last + str.substring(0, str.length()-1));
                break;

        }

        return result;
    }
}
