package programmers;

import java.util.Arrays;

public class Solution_16 {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int t=0;t< commands.length;t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];

            int[] temp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(temp);
            answer[t] = temp[k-1];
        }

        return answer;
    }

}
