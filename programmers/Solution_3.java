package programmers;

public class Solution_3 {

    public  static void main(String[] args) {

        solution("...!@BaT#*..y.abcdefghijklm");
    }

    public static String solution(String new_id) {

        String answer = "";

        //정규 표현식 문제

        StringBuilder id = new StringBuilder(new_id.toLowerCase()); // 1단계

        id = new StringBuilder(id.toString().replaceAll("[^\\w\\-_.]*", "")); // 2단계

        id = new StringBuilder(id.toString().replaceAll("\\.{2,}", ".")); // 3단계

        id = new StringBuilder(id.toString().replaceAll("^[.]|[.]$", "")); // 4단계

        if(id.length() == 0) { // 6단계
            id = new StringBuilder("a");
        }else if(id.length() >= 16) {
            id = new StringBuilder(id.substring(0, 15));
            id = new StringBuilder(id.toString().replaceAll("[.]$", ""));
        }

        if(id.length() < 3) { // 7단계
            char last = id.charAt(id.length() - 1);
            while(true) {
                id.append(last);

                if(id.length() == 3) {
                    break;
                }
            }
        }

        System.out.println(id);


        return answer;
    }
}
