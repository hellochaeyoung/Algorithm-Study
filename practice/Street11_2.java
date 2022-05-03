package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Street11_2 {

    public static void main(String[] args) {
        int[] A = {2,5,6,4,3,1,7,9,8,10};

        System.out.println(solution(A));
    }
    public static int solution(int[] A) {

        boolean[] check = new boolean[A.length+1];
        check[0] = true;
        int cnt = 0;

        List<Integer> list = new ArrayList<>();
        for(int n : A) {
            if(check[n-1]) {
                check[n] = true;

                while(list.contains(n+1)) {
                    list.remove(Integer.valueOf(n+1));
                    check[n+1] = true;
                    n = n+1;
                }

                cnt++;
            }
            else {
                list.add(n);
            }
        }

        return cnt;
    }
}
