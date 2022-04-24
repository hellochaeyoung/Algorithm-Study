package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_32 {

    static int[] nums = {1,2,4};
    static int[] arr;
    static int N, num;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 18;

        System.out.println(solution(n));
        System.out.println(calc(n));
    }

    public static String solution(int n) {
        String answer = "";

        num = n;

        int cnt = 1;
        while(list.size() < n) {
            arr = new int[cnt];
            N = cnt;

            dfs(0, 0);

            cnt++;
        }

        answer = list.get(n-1);

        return answer;
    }

    static String calc(int n) {

        int rest = 0;
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            rest = n%3;
            n = n/3;

            if(rest == 0) {
                rest = 4;
                n -= 1;
            }

            sb.insert(0, rest);
        }

        return sb.toString();
    }

    // n의 범위가 500,000,000 이하이므로 완전탐색으로는 정확도는 맞지만 효율성에서 통과하지 못한다.
    static void dfs(int index, int depth) {

        if(depth == N) {
            StringBuilder sb = new StringBuilder();
            for(int i : arr) {
                sb.append(i);
            }
            list.add(sb.toString());
            return;
        }

        for(int i=0;i<nums.length;i++) {
            arr[index] = nums[i];

            dfs(index + 1, depth + 1);
        }
    }
}
