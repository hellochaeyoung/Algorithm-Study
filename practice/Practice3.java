package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice3 {

    public static void main(String[] args) {

        //String[] color = {"RG", "WR", "BW", "GG"};
        //String[] color = {"RG", "WR", "BW", "GG"};
        String[] color = {"BW", "RY", "BY"};
        //int[] prices = {5000, 6000};
        //int[] prices = {2000, 6000};
        int[] prices = {9000, 10000};

        List<String> top = new ArrayList<>();
        List<String> bottom = new ArrayList<>();

        for(String key : color) {
            String s1 = key.split("")[0];
            String s2 = key.split("")[1];

            top.add(s1);
            bottom.add(s2);
        }

        int sameCount = 0;
        int differCount = 0;

        for(String s : top) {
            if(bottom.contains(s)) {
                sameCount++;
            }else {
                differCount++;
            }
            bottom.remove(s);
        }

        differCount += bottom.size();

        int sum1 = sameCount * prices[0] + (differCount / 2) * prices[1];
        int sum2 = (sameCount + differCount) * prices[0];
        int sum3 = (sameCount + differCount) * prices[1];

        int answer = Math.min(sum1, sum2);
        answer = Math.min(answer, sum3);

        System.out.println(answer);


    }
}
