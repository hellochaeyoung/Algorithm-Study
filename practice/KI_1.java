package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KI_1 {

    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7,1,3};

        System.out.println(solution(survey, choices));

    }
    public static String solution(String[] survey, int[] choices) {

        char[][] characters = new char[][]{{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] score = new int[] {0,3,2,1,0,1,2,3};

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<survey.length;i++) {
            String st = survey[i];
            int ch = choices[i];

            if(ch != 4) {
                char key = (ch < 4) ? st.charAt(0) : st.charAt(1);
                map.put(key, map.getOrDefault(key, 0) + score[ch]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char[] arr : characters) {
            int s1 = Optional.ofNullable(map.get(arr[0])).orElse(0);
            int s2 = Optional.ofNullable(map.get(arr[1])).orElse(0);;

            if(s1 == s2) {
                sb.append(arr[0]);
            }else {
                char character = (s1 > s2) ? arr[0] : arr[1];
                sb.append(character);
            }
        }

        return sb.toString();
    }
}
