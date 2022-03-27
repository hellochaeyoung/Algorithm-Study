package practice;

import java.util.Arrays;

public class Line_1 {

    static String[] name = {"team_name", "application_name", "error_level", "message"};

    public static void main(String[] args) {

        String[] logs = {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"};

        System.out.println(solution(logs));

    }

    public static int solution(String[] logs) {
        int answer = 0;

        for(String log : logs) {
            if(log.length() > 100) {
                answer++;
            }else {
                String[] arr = log.split(" ");
                if(!check(arr)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    static boolean check(String[] arr) {

        String reg = "^[a-zA-Z]*$";

        if(arr.length != 12) {
            return false;
        }

        for(int i=0;i<arr.length;i++) {
            if(i % 3 == 0) {
                if(!arr[i].equals(name[i / 3])) {
                    return false;
                }
            }else if(i % 3 == 2) {
                if(arr[i].length() < 1) {
                    return false;
                }

                if(!arr[i].matches(reg)) {
                    return false;
                }
            }else {
                if(!arr[i].equals(":")){
                    return false;
                }
            }
        }

        return true;
    }
}
