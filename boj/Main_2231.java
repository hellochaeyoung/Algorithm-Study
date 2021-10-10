package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        
        int num = Integer.parseInt(N);

        int minConstructor = getMinConstructor(num);

        print(minConstructor);
    }

    static int getMinConstructor(int N) {

        int sum = 0;
        for(int i=1;i<N;i++) {
            String s = String.valueOf(i);
            String str[] = s.split("");
            sum += i;
            for(int j=0;j<str.length;j++) {
                sum += Integer.parseInt(str[j]);
            }

            if(sum == N) {
                return i;
            }

            sum = 0;
        }

        return sum;
    }

    static void print(int minConstructor) {
        System.out.println(minConstructor);
    }
}
