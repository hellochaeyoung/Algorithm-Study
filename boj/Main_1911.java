package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1911 {

    static int N,L;
    static List<int []> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.add(new int[] {from, to});
        }

        list.sort((Comparator.comparingInt(o -> o[0])));

        int cnt = 0;
        int range = 0;
        for(int[] arr : list) {
            if(arr[0] > range) {
                range = arr[0];
            }
            if(arr[1] >= range) {
                while(arr[1] > range) {
                    range += L;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
