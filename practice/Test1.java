package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Coin {
    int won;
    double cost;

    public Coin(int won, double cost) {
        this.won = won;
        this.cost = cost;
    }
}

public class Test1 {

    static int[] won = {1,5,10,50,100,500};

    public static int solution(int money, int[] costs) {
        int answer = 0;

        List<Coin> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<won.length;i++) {
            list.add(new Coin(won[i], (double)costs[i] / won[i]));
            map.put(won[i], costs[i]);
        }

        list.sort((o1, o2) -> {
            if(o1.cost == o2.cost) {
                return Integer.compare(o2.won, o1.won);
            }
            return Double.compare(o1.cost, o2.cost);
        });

        for (Coin coin : list) {
            int m = coin.won;

            int mn = money / m;
            answer += mn * map.get(m);
            money %= m;
        }

        return answer;

    }

    public static void main(String[] args) {

        int money = 500;
        //int[] costs = {1, 4, 99, 35, 50, 1000};
        int[] costs = {1000,1000,1000,100, 100, 500};

        System.out.println(solution(money, costs));
    }
}
