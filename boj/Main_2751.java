package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        int[] arr = new int[N];
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : list) {
            sb.append(i + "\n");
        }

        System.out.println(sb);

    }
}
