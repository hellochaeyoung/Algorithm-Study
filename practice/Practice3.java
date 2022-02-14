package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice3 {

    static class Cloth {
        String c;
        int division;

        public Cloth(String c, int division) {
            this.c = c;
            this.division = division;
        }
    }

    public static void main(String[] args) {

        //String[] color = {"RG", "WR", "BW", "GG"};
        String[] color = {"RG", "WR", "BW", "GG"};
        int[] prices = {5000, 6000};

        Map<String, Integer> map = new HashMap<>();

        List<Cloth> top = new ArrayList<>();
        List<Cloth> bottom = new ArrayList<>();

        for(String key : color) {
            String s1 = key.split("")[0];
            String s2 = key.split("")[1];

            top.add(new Cloth(s1, 0));
            bottom.add(new Cloth(s2, 1));

            map.put(s1, map.getOrDefault(s1, 0) + 1);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
        }
        int sameCount = 0;
        int differCount = 0;

        for(Cloth c : top) {
            
        }


        for(int value : map.values()) {
            if(value % 2 == 0) {
                sameCount++;
            }else {
                sameCount += (value / 2);
                differCount++;
            }
        }

        int sum1 = sameCount * prices[0] + (differCount / 2) * prices[1];
        int sum2 = (sameCount + differCount) * prices[0];
        int sum3 = (sameCount + differCount) * prices[1];

        int answer = Math.min(sum1, sum2);
        answer = Math.min(answer, sum3);

        System.out.println(answer);


    }
}
