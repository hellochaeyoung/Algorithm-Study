package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_37 {

    public static void main(String[] args) {

        String p = "()))((()";

        System.out.println(solution(p));

    }
    public static String solution(String p) {
        String answer = "";

        if(check(p)) return p;

        answer = make(p);

        return answer;
    }

    static String make(String st) {

        if(st.equals("")) {
            return "";
        }

        String u,v;
        if(st.length() == 2) {
            u = st;
            v = "";
        }else {
            String result = find(st);
            u = result.split(" ")[0];
            v = result.split(" ")[1];
        }

        StringBuilder sb = new StringBuilder();

        if(check(u)) {
            return u + make(v);
        }else {
            sb.append("(");

            sb.append(make(v));

            sb.append(")");

            //첫번째, 마지막 문자 제거
            u = u.substring(1);
            u = u.substring(0, u.length() - 1);

            // 괄호 뒤집어서 뒤에 붙이기
            for(int i=0;i<u.length();i++) {
                if(u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
        }

        return sb.toString();
    }

    static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(stack.isEmpty()){
                if(ch == '(') {
                    stack.push('(');
                }else {
                    return false;
                }
            }else {
                if(stack.peek() != ch) {
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }

        }

        return stack.isEmpty();
    }

    static String find(String s) {

        int[] cnt = new int[2];

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(ch == '(') cnt[0]++;
            else cnt[1]++;

            if(cnt[0] == cnt[1]) {
                String u = s.substring(0, i+1);
                String v = s.substring(i+1);

                return u + " " + v;
            }
        }

        return "";
    }
}
