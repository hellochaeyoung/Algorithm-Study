package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_12 {

    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        List<Long> list = new ArrayList<>(); // 런타임 에러 발생, int -> Long으로 변경해 해결
        // 1번 예제처럼 437674를 3진수로 변환 시 211020101011로 변환된다.
        // int의 범위를 벗어날 가능성이 있으므로 int형 대신 Long형을 사용하여 해결한다.

        while(true) {
            int rest = n % k;
            n /= k;

            if(rest == 0) {
                if(!sb.toString().equals("")) {
                    list.add(Long.parseLong(sb.toString()));
                    sb.setLength(0);
                }
            }else {
                sb.insert(0, rest);
            }

            if(n < k) {
                sb.insert(0, n);
                list.add(Long.parseLong(sb.toString()));
                break;
            }

        }

        for(Long i : list) {
            if(isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(Long num) {

        if( num == 1) {
            return false;
        }else if(num == 2) {
            return true;
        }

        for(int i=2;i<=Math.sqrt(num);++i) {
            if(num % i == 0) {
                 return false;
            }
        }

        return true;
    }
}
