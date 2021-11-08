package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_7568 {

    static int[][] people;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        people = new int[N][2];
        arr = new int[N];

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        check();

        print();
    }

    static void check() {

        for(int i=0;i< people.length;i++) {
            int weight = people[i][0];
            int height = people[i][1];
            int count = 0;
            for(int j=0;j< people.length;j++) {
                if(people[j][0] > weight && people[j][1] > height) {
                    count++;
                }
            }
            arr[i] = count + 1;
        }
    }

    static void print() {
        for(int n : arr) {
            System.out.print(n + " ");
        }
    }
}
