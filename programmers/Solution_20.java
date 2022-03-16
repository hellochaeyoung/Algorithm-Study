package programmers;

public class Solution_20 {

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(45));

    }
    public static int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while(true) {
            int rest = n % 3;
            n /= 3;
            sb.insert(0, rest);

            if(n == 0) {
                break;
            }

            if(n < 3) {
                sb.insert(0, n);
                break;
            }
        }

        String[] num = sb.reverse().toString().split("");

        for(int i=0;i<num.length;i++) {
            int m = Integer.parseInt(num[i]);
            answer += m * Math.pow(3, num.length - 1 - i);
        }

        return answer;
    }

    static int otherSolution(int n) {
        String a = "";

        while(n > 0) {
            a = (n % 3) + a;
            n /= 3;
        }

        return Integer.parseInt(a, 3); // Integer.parseInt("String", n진수)
    }
}
