package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> list = Arrays.stream(win_nums)
                .boxed().collect(Collectors.toList());

        int zeroCount = 0;
        int correctCount = 0;
        for(int i : lottos) {
            if(i == 0) {
                zeroCount++;
            }else {
                if(list.contains(i)) {
                    correctCount++;
                }
            }

        }

        int best = correctCount + zeroCount;
        int worst = correctCount;

        if(best == 0){
            answer[0] = 6;
        }else {
            answer[0] = (6 - best)  + 1;
        }

        if(worst == 0) {
            answer[1] = 6;
        }else {
            answer[1] = (6 - worst) + 1;
        }


        return answer;
    }
}
