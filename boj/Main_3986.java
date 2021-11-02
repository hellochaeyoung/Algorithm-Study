package boj;

import java.io.*;
import java.util.Stack;

// Stack을 활용하면 쉽게 풀 수 있다는 생각을 못함...왜...
public class Main_3986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i=0;i<N;i++) {
            String word = br.readLine();

            if(check(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean check(String word) {

        Stack<Character> stack = new Stack<>();

        stack.push(word.charAt(0));

        for(int i=1;i<word.length();i++) {
            char now = word.charAt(i);
            if(!stack.isEmpty()) {
                char peek = stack.peek();

                if(peek == now) {
                    stack.pop();
                }else {
                    stack.push(now);
                }
            }else {
                stack.push(now);
            }
        }

        if(stack.size() == 0) {
            return true;
        }else {
            stack.clear();
            return false;
        }
    }
}
