package programmers;

public class Solution_8 {

    public int solution(int[] absolutes, boolean[] signs) {

        int sum = 0;
        for(int i=0;i<signs.length;i++) {
            if(!signs[i]) {
                sum += (absolutes[i] * -1);
            }else {
                sum += absolutes[i];
            }
        }

        return sum;
    }

    static int otherSolution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<signs.length;i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }

        return answer;
    }
}
