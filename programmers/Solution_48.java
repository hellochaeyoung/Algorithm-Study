package programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution_48 {

    static String[] arr;
    static String[] numArr;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "17";

        solution(numbers);
        System.out.println(set.size());
    }

    public static int solution(String numbers) {

        arr = new String[numbers.length()];
        visited = new boolean[numbers.length()];

        numArr = numbers.split("");

        for(int i=1;i<=numbers.length();i++) {
            dfs(0,i);
        }

        return set.size();
    }

    static void dfs(int depth, int count) {

        if(depth == count) {
            StringBuilder sb = new StringBuilder();
            for(String s : arr) {
                if(s == null) break;
                sb.append(s);
            }

            int result = Integer.parseInt(sb.toString());

            System.out.println(result);
            if(isPrime(result)) set.add(result);

            return;
        }

        for(int i=0;i<numArr.length;i++) {
            if(!visited[i]) {
                visited[i] = true;

                arr[depth] = numArr[i];
                dfs(depth+1, count);

                visited[i] = false;
            }
        }

    }

    static boolean isPrime(int n) {

        if(n == 0 || n == 1) return false;

        for(int i=2;i<n;i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
