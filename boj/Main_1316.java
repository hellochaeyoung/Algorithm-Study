package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main_1316 {

    static BufferedReader br;
    static int number;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i=0;i<number;i++) {
            if(check()) {
                count++;
            }
        }

        System.out.println(count);

    }

    public static boolean check() throws IOException {

        boolean[] check = new boolean[26];
        String st = br.readLine();

        char prev = ' ';
        for(char c : st.toCharArray()) {
            if(check[c - 'a']){
                if(prev == c) {
                    continue;
                }else {
                    return false;
                }

            }else {
                check[c - 'a'] = true;
                prev = c;
            }
        }

        return true;
    }
}

