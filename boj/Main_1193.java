package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int line = -1;
        int n = 0;
        int prev = 0;
        int rest = 0;

        if(x == 1) {
            System.out.println(x + "/" + x);
            return;
        }

        while(true) {
            if( x <=(n*(n+1)/2)) {
                prev = n*(n-1)/2;
                rest = x - prev;
                break;
            }
            line++;
            n++;
        }

        if(line % 2 == 1) {
            int mm = line + 1 - (rest - 1);
            int nn = 1 + (rest - 1);
            System.out.println(nn + "/" + mm);
        }else {
            int mm = 1 + (rest - 1);
            int nn = line + 1 - (rest - 1);
            System.out.println(nn + "/" + mm);
        }
    }
}
