package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_17 {

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

        List<int []> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);

        List<int[]> counts = new ArrayList<>();
        int id = 0;
        int max = Integer.MIN_VALUE;

        for(int[] arr : list) {
            int index = 0;
            int count = 0;
            for (int j : answers) {
                if (index == arr.length) {
                    index = 0;
                }

                if (j == arr[index]) {
                    count++;
                }

                index++;
            }

            if(max == count) {
                counts.add(new int[] {id, count});
            }else if(max < count) {
                counts.clear();
                counts.add(new int[] {id, count});
                max = count;
            }

            id++;
        }

        answer = new int[counts.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = counts.get(i)[0] + 1;
        }

        return answer;
    }
}
