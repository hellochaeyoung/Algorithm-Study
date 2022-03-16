package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_19 {

    public int solution(int left, int right) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=left;i<=right;i++) {

            int cnt = 0;
            for(int j=1;j<=i;j++) {
                if(i % j == 0) {
                    cnt++;
                }
            }
            list.add(cnt);
        }

        for(int i=0;i<list.size();i++) {
            int cnt = list.get(i);
            if(cnt % 2 == 0) {
                answer += i + left;
            }else {
                answer -= i + left;
            }
        }

        return answer;
    }

    static int otherSolution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++) {
            if(i % Math.sqrt(i) == 0) {
                answer -= i;
            }else {
                answer += i;
            }
        }

        return answer;
    }
}
