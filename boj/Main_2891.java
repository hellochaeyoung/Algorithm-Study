package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2891 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int answer = S;

        int[] destroy = new int[S];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++) {
            destroy[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] oneMoreTeams = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++) {
            int idx = Integer.parseInt(st.nextToken());
            oneMoreTeams[idx] = true;
        }

        for (int t : destroy) {
            if(oneMoreTeams[t]) {
                oneMoreTeams[t] = false;
                answer--;
            } else if (t != 1 && oneMoreTeams[t - 1]) {
                oneMoreTeams[t - 1] = false;
                answer--;
            } else if (t != N && oneMoreTeams[t + 1]) {
                oneMoreTeams[t + 1] = false;
                answer--;
            }
        }

        System.out.println(answer);

    }

}
