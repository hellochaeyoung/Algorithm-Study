package programmers;

import java.lang.reflect.Array;
import java.util.*;

public class Solution_45 {

    public static void main(String[] args) {
        //"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
        //"AA", "AB", "AC", "AA", "AC"
        //"XYZ", "XYZ", "XYZ"
        //"ZZZ", "YYY", "NNNN", "YYY", "BBB"

        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        System.out.println(Arrays.toString(solution(gems)));

    }
    public static int[] solution(String[] gems) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(gems));

        int start=0, end=0;
        map.put(gems[start], map.getOrDefault(gems[start], 0) + 1);

        int len = Integer.MAX_VALUE;
        answer = new int[2];
        while(start <= end && end < gems.length) {

            /*if(!checked[start]) {
                checked[start] = true;
                map.put(gems[start], map.getOrDefault(gems[start], 0) + 1);
            }

            if(!checked[end]) {
                checked[end] = true;
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            }*/

            if(map.size() == set.size()) {
                int range = Math.abs(start - end);

                if(len > range) {

                    len = range;
                    answer[0] = start+1;
                    answer[1] = end+1;

                }else if(len == range) {

                    if(answer[0] > start + 1) {
                        answer[0] = start+1;
                        answer[1] = end+1;
                    }
                }

                map.put(gems[start], map.getOrDefault(gems[start], 0) - 1);
                if(map.get(gems[start]) == 0) map.remove(gems[start]);
                start++;
            }else {
                end++;
                if(end >= gems.length) {
                    break;
                }else {
                    map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                }
            }

        }

        return answer;
    }

}
