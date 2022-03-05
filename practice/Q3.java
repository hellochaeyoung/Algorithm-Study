package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++) {
            int n = S.charAt(i) - 'a';
            char w = calc(n, a, b);
            sb.append(w);
        }

        System.out.println(sb);
    }

    static char calc(int n, int a, int b) {

        int divide = 0;
        while(true) {
            if(b != n) {
                n += 26;
            }

            divide = (n - b) / a;
            int rest = (n - b) % a;

            if(rest == 0) {
                break;
            }
        }

        return (char)(divide + 'a');
    }

}
