package programmers;

import java.util.Arrays;

public class Solution_11 {

    public static void main(String[] args) {

        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        solution(n, lost, reserve);

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0;i< lost.length;i++) {
            for(int j=0;j<reserve.length;j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }

        for(int i=0;i< lost.length;i++) {
            for (int j=0;j<reserve.length;j++) {
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
