package programmers;

import java.util.Stack;

public class Solution_53 {

    public static void main(String[] args) {
        String s = "}}}";

        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            sb.delete(0,1);
            sb.append(ch);

            if(check(sb.toString())) answer++;
        }
        return answer;
    }

    static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(stack.isEmpty()) stack.push(ch);
            else {
                if(ch == ']' && stack.peek() == '[') stack.pop();
                else if(ch == '}' && stack.peek() == '{') stack.pop();
                else if(ch == ')' && stack.peek() == '(') stack.pop();
                else stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
