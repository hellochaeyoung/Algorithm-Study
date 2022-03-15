package practice;

import java.util.StringTokenizer;

public class Skill2_1 {

    public static void main(String[] args) {

        System.out.println(solution("for the last    week"));

    }
    public static String solution(String s) {
        String answer = "";

        String[] arr = s.toLowerCase().split("");
        boolean flag = true;

        for(String st : arr) {
            answer += flag ? st.toUpperCase() : st;
            flag = st.equals(" ");
        }
        return answer;
    }
}
