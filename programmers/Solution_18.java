package programmers;


import java.util.Arrays;

public class Solution_18 {

    public int solution(int[] nums) {
        int answer = 0;

        int[] temp = Arrays.stream(nums).distinct().toArray();

        int cnt = nums.length / 2;

        if(temp.length >= cnt) {
            answer = cnt;
        }else {
            answer = temp.length;
        }

        return answer;
    }
}
