package programmers;

public class Solution_23 {

    static int N, T;
    static int cnt = 0;

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        solution(numbers, target);

        System.out.println(cnt);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        N = numbers.length;
        T = target;

        dfs(numbers, 0,0);

        return answer;
    }

    static void dfs(int[] numbers, int sum, int depth) {

        if(depth == N) {
            if(sum == T) {
                cnt++;
            }
        }else {
            dfs(numbers, sum + numbers[depth], depth+1);
            dfs(numbers, sum - numbers[depth], depth+1);
        }
    }
}
