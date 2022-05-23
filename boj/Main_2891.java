package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int answer = 0;

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

        Arrays.sort(destroy);

        for (int i=0;i<S;i++) {
            int t = destroy[i];
            if(oneMoreTeams[t]) {
                oneMoreTeams[t] = false;
            }else {
                if (t > 1 && oneMoreTeams[t - 1]) {
                    oneMoreTeams[t - 1] = false;
                }else {
                    if (t != N && oneMoreTeams[t + 1]) {
                        oneMoreTeams[t + 1] = false;
                    }else {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);

    }

}
