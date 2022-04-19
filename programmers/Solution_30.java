package programmers;

import java.math.BigInteger;

public class Solution_30 {

    public long solution(int w, int h) {
        long answer = 1;

        if(h > w) {
            int temp = w;
            w = h;
            h = temp;
        }

        //long result = gcd(w, h);

        long result = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        long cnt = w + h - result;
        answer = (long) w * h - cnt;

        return answer;
    }

    static long gcd(long a, long b) {
        if(a%b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
}
