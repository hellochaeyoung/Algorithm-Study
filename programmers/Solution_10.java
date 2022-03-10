package programmers;

import java.util.*;

public class Solution_10 {

    static class Stage {
        int index;
        double rate;

        public Stage(int index, double rate) {
            this.index = index;
            this.rate = rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] count = new int[N+2];
        int[] totalCount = new int[N+1];

        for(int i=0;i< stages.length;i++) {
            count[stages[i]]++;
        }

        totalCount[N] = count[N] + count[N+1];
        for(int i=N-1;i>=1;i++) {
            totalCount[i] = count[i] + totalCount[i+1];
        }

        List<Stage> list = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            if(totalCount[i] == 0){
                list.add(new Stage(i, 0));
                continue;
            }

            double rate = (double) count[i] / totalCount[i];
            list.add(new Stage(i, rate));
        }

        Collections.sort(list, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));

        int id = 0;
        for(Stage s : list) {
            answer[id] = s.index;
            id++;
        }

        return answer;
    }
}
