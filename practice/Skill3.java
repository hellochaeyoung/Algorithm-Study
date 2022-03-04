package practice;

import java.util.Arrays;

public class Skill3 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int sum = 0;
        int count = 0;
        for(int i=0;i<d.length;i++) {
            if(budget - sum < d[i]){
                break;
            }
            sum += d[i];
            count++;
        }

        return count;
    }
}
