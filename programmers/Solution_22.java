package programmers;

import java.util.*;

public class Solution_22 {

    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};

        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        for(int i=0;i< numbers.length-1;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                int sum = numbers[i] + numbers[j];
                list.add(sum);
            }
        }

        Collections.sort(list);
        answer = list.stream().distinct().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    static int[] otherSolution(int[] numbers) {
        // HashSet이 아닌 TreeSet을 사용하면 자동으로 오름차순 정렬됨!!!!
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i< numbers.length-1;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        return set.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}
