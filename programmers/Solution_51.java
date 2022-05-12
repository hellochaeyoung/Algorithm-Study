package programmers;

public class Solution_51 {

    public static void main(String[] args) {
        int n = 32, a = 10, b = 12;

        System.out.println(solution(n, a, b));
    }
    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        int mid = n / 2;

        int height = 0;
        int total = n;
        while(total != 1) {
            total /= 2;
            height++;
        }

        int temp = a;
        if(a > b) {
            a = b;
            b = temp;
        }

        int stmp = 1;
        int etmp = n;
        while(true) {
            if(a <= mid && b > mid) {
                answer = height;
                break;
            }else if(b <= mid) {
                etmp = mid;
                mid = (stmp + etmp) / 2;
            }
            else {
                stmp = mid;
                mid = (stmp + 1 + etmp) / 2;
            }
            height--;
        }

        return answer;
    }

    static int otherSolution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            a = a/2 + a%2;
            b = b/2 + b%2;

            answer++;
            if(a == b) break;
        }

        return answer;
    }

}
