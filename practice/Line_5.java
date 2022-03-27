package practice;

import java.util.Arrays;
import java.util.Collections;

public class Line_5 {

    static int total;
    static Integer[] arr;
    static boolean[] visited;
    static long max = Long.MIN_VALUE;

    static int[] temp;
    static int N;

    public static void main(String[] args) {
        int[] abilities = {7, 6, 8, 9, 10};
        int k = 1;

        System.out.println(solution(abilities,k));
    }

    public static long solution(int[] abilities, int k) {

        total = k;

        if(abilities.length % 2 == 0) {
            N = abilities.length;
        }else {
            N = abilities.length + 1;
        }

        arr = Arrays.stream(abilities).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        visited = new boolean[abilities.length];
        temp = new int[N / 2];

        dfs(0,0);

        return max;
    }

    static void dfs(int start, int depth) {

        if(depth == N / 2) {
            System.out.println(Arrays.toString(temp));
            long sum = 0;
            for(int i : temp) {
                sum += i;
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=start;i<arr.length;i+=2) {
            if(!visited[i]) {
                visited[i] = true;

                if(total != 1) {
                    temp[depth] = arr[i];
                    dfs(start+2, depth+1);
                }

                if(i == arr.length-1) {
                    temp[depth] = arr[i];
                }else {
                    temp[depth] = arr[i+1];
                }
                dfs(start+2, depth+1);

                visited[i] = false;
            }
        }
    }
}
