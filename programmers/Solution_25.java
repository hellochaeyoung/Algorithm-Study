package programmers;

import java.util.*;

public class Solution_25 {

    static Map<String, String> map;
    static Map<String, Integer> income;

    public static void main(String[] args) {
        /*
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

         */

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        map = new HashMap<>();
        income = new HashMap<>();

        for(int i=0;i< enroll.length;i++) {
            if(referral[i].equals("-")) {
               map.put(enroll[i], "center");
            }else {
               map.put(enroll[i], referral[i]);
            }
            income.put(enroll[i], 0);
        }

        for(int i=0;i< seller.length;i++) {
            int money = 100 * amount[i];
            String sell = seller[i];
            String up = map.get(sell);

            calc(sell, up, money);
        }

        int c = 0;
        answer = new int[enroll.length];
        for(String key : enroll) {
            int m = income.get(key);
            answer[c++] = m;
        }

        return answer;
    }

    static void calc(String sell, String up, int money) {

        Map<String, Integer> temp = new HashMap<>();

        while(true) {

            int forRecommender = (int) (money * 0.1);
            int forSeller = money - forRecommender;

            if(forRecommender < 1) {
                forRecommender = 0;
                forSeller = money;
            }

            temp.put(sell, forSeller);
            temp.put(up, forRecommender);

            if(up.equals("center") || forRecommender == 0) {
                break;
            }

            sell = up;
            up = map.get(sell);
            money = forRecommender;
        }

        for(String key : temp.keySet()) {
            income.put(key, income.getOrDefault(key, 0) + temp.get(key));
        }

    }
}
