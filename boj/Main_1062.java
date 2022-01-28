package boj;

import java.util.*;
import java.io.*;

public class Main_1062 {

    static int N, K;
    static List<String> list = new ArrayList<>();
    static boolean[] visited = new boolean[26];
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K < 5) {
            System.out.println(0);
            return;
        }else if(K == 26) {
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            s = s.replace("anta", "");
            s = s.replace("tica", "");
            list.add(s);
        }

        backTracking(0,0);

        System.out.println(max);
    }

    static void backTracking(int alpha, int len) {

        if(len == K - 5) {
            int count = 0;
            for(String word : list) {
                boolean check = true;
                for(int i=0;i<word.length();i++) {
                    if(!visited[word.charAt(i) - 'a']) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        for(int i=alpha;i<26;i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(i, len+1);

                visited[i] = false;
            }
        }
    }
}
