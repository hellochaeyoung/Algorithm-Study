package boj;

import java.io.*;
import java.util.*;

public class Main_14888 {

    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Long> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        String[] str = {"+", "-", "*", "/"};
        for(int i=0;i<operators.length;i++) {
            operators[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<operators[i];j++) {
                list.add(str[i]);
            }

        }

        visited = new boolean[list.size()];

        if(visited.length == 1) {
            System.out.println(calc(list.get(0), numbers[0], numbers[1]));
            System.out.println(calc(list.get(0), numbers[0], numbers[1]));
            return;
        }

        dfs(numbers[0], 1,1);

        Collections.sort(results);

        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
    }

    static void dfs(long pre, int depth, int start) {

        if( depth == N) {
            results.add(pre);
            return;
        }

        for(int i=0;i<numbers.length-1;i++) {
            if(!visited[i]) {
                visited[i] = true;
                long result = calc(list.get(i), pre, numbers[start]);

                dfs(result, depth+1, start+1);
                visited[i] = false;
            }
        }

        return;
    }

    static long calc(String ope, long n1, long n2) {

        long result = 0;
        switch (ope) {
            case "+" : result = n1 + n2; break;
            case "-" : result = n1 - n2; break;
            case "*" : result = n1 * n2; break;
            case "/" : result = n1 / n2; break;

        }

        return result;
    }
}
