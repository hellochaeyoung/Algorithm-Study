package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_3273 {

    static int[] arr;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            map.put(num, 1);
        }

        int x = Integer.parseInt(br.readLine());

        int count = getCount(n, x);

        System.out.println(count);
    }

    static int getCount(int n, int x) {
        int count = 0;

        for(int i=0;i<n;i++) {
            int key = x - arr[i];
            if(map.containsKey(key)) {
                count++;
            }
        }
        return count/2;
    }
}
