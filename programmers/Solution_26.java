package programmers;

public class Solution_26 {

    public static void main(String[] args) {
        String s = "aabbaccc";

        System.out.println(solution(s));
    }

    public static int solution(String s) {

        int min = Integer.MAX_VALUE;
        int len = 1;

        if(s.length() == 1) {
            return 1;
        }

        while(len <= s.length() / 2) {

            int cnt = 1;

            String str = "";
            String temp = "";

            for(int i=0;i<s.length()/len;i++) {
                String now = s.substring(i*len, (i*len)+len);

                if(temp.equals(now)) {
                    cnt++;
                    continue;
                }

                if(cnt > 1) {
                    str += cnt + temp;
                    cnt = 1;
                }else {
                    str += temp;
                }

                temp = now;
            }

            if(cnt > 1) {
                str += cnt + temp;
                cnt = 1;
            }else {
                str += temp;
            }

            if(s.length() % len != 0) {
                str += s.substring(s.length() - s.length()%len);
            }

            min = Math.min(min, str.length());

            len++;
        }

        return min;
    }
}
