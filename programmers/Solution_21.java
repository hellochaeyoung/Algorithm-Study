package programmers;

import java.util.Arrays;

public class Solution_21 {

    public static void main(String[] args) {

        int[] d = {2,2,3,3};
        //int[] d = {1,3,2,5,4};
        int budget = 10;
        System.out.println(solution(d, budget));

    }
    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int sum = 0;
        for(int i=0;i<d.length;i++) {
            sum += d[i];
            if(sum > budget) {
                break;
            }
            answer = i+1;
        }

        return answer;
    }

    static int otherSolution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int i=0;i<d.length;i++) {
            budget -= d[i]; // 빼는 방법!!!!!

            if(budget < 0) break;

            answer++;
        }

        return answer;
    }
}
