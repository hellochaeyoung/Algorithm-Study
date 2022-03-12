package practice;

public class Test1 {

    static int N;
    static int[] arr;
    static int cost;
    static int[] costArr;
    static int[] won = {1,5,10,50,100,500};
    static int min = Integer.MAX_VALUE;

    static void dfs(int result, int answer, int index, int repeat) {

        if(result < 0) {
            return;
        }

        if(repeat == -1 && result > 0) {
            return;
        }

        if(result == 0) {
            min = Math.min(min, answer);
            return;
        }

        for(int i=repeat;i>=0;i--) {

            result -= won[index] * i; // 생산 비용
            answer += costArr[index] * i; // 결과

            int next = -1;
            if(index != 0) {
                next = result / won[index - 1];
            }

            dfs(result, answer, index - 1, next);

            //index++;

            result += won[index] * i;
            answer -= costArr[index] * i;


        }
    }
    public static int solution(int money, int[] costs) {

        N = costs.length;
        arr = new int[N];

        cost = money;
        costArr = costs.clone();

        int repeat = money / costs[N-1];

        dfs(money,0, N-1, repeat);

        return min;
    }

    public static void main(String[] args) {

        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};

        System.out.println(solution(money, costs));
    }
}
