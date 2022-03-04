package practice;

public class Skill4 {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int min = (n < m) ? n : m;

        int max = 0;
        for(int i=1;i<=min;i++) {
            if(n % i == 0 && m % i == 0) {
                max = i;
            }
        }

        answer[0] = max;
        answer[1] = (n * m) / max;

        return answer;
    }

}
