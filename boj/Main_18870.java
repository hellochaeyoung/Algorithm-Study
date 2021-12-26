package boj;

import java.io.*;
import java.util.*;

public class Main_18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] totalArr = arr.clone();

        HashSet<Integer> set = new HashSet<>(Arrays.asList(totalArr)); // 중복 제거
        Integer[] total = set.toArray(new Integer[0]);

        Arrays.sort(total); // 정렬

        HashMap<Integer, Integer> map = new HashMap<>(); // 속도 향상 위해 해시맵 사용
        for(int i=0;i<total.length;i++) {
            map.put(total[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(map.get(n) + " ");
        }

        System.out.println(sb);

    }
}
