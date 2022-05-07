package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class KI_2 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] queue1 = {1,2,1,2};
        int[] queue2 = {1,10,1,2};

        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {

        List<Long> list1 = Arrays.stream(queue1).asLongStream().boxed().collect(Collectors.toList());
        List<Long> list2 = Arrays.stream(queue2).asLongStream().boxed().collect(Collectors.toList());
        find(list1, list2);

        list1 = Arrays.stream(queue1).asLongStream().boxed().collect(Collectors.toList());
        list2 = Arrays.stream(queue2).asLongStream().boxed().collect(Collectors.toList());
        find(list2, list1);

        return answer;
    }

    static void find(List<Long> list1, List<Long> list2) {

        long sum1 = list1.stream().mapToInt(Long::intValue).sum();
        long sum2 = list2.stream().mapToInt(Long::intValue).sum();

        long find = (sum1 + sum2) / 2;

        int cnt = 0;
        while(true) {

            long n = list1.remove(0);
            list2.add(n);
            cnt++;

            sum2 += n;
            long temp = sum2 - find;
            if(list2.contains(temp)) {
                int c = list2.indexOf(temp);
                cnt += 2*c + 1;
                break;
            }else {
                if(list1.size() == 0) {
                    cnt = -1;
                    break;
                }
            }
        }

        answer = Math.min(answer, cnt);

    }
}
