package programmers;

import java.util.Arrays;

public class Solution_7 {

    public int solution(int[] numbers) {

        boolean[] check = new boolean[10];

        for(int n : numbers) {
            check[n] = true;
        }

        int sum = 0;
        for(int i=0;i<check.length;i++) {
            if(!check[i]) {
                sum += i;
            }
        }
        return sum;
    }

    public int otherSolution(int[] numbers) {
        int sum = 45;
        for(int i : numbers) {
            sum -= i;
        }

        return sum;
    }

    public int otherSolution2(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
