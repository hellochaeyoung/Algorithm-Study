package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ssg_1 {

    public static void main(String[] args) {
        int[] v = {4,4,3};
        int a = 2, b = 1;

        System.out.println(solution(v,a,b));
    }
    public static int solution(int[] v, int a, int b) {

        int answer = 0;

        List<Integer> list = Arrays.stream(v).boxed().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());

        boolean check = true;
        while(true) {

            System.out.println(list.toString());
            list.set(0, list.get(0)-a);
            for(int i=1;i<list.size();i++) {
                list.set(i, list.get(i)-b);
            }

            int t1 = list.get(0);
            int t2 = list.get(1);
            if(t1 < t2) {
                if(t2 < a) {
                    break;
                }
                list.add(list.remove(0));
            }

            answer++;
        }

        return answer;
    }


}
