package programmers;

import java.util.Stack;

public class Solution_6 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int m : moves) {
            int index = m-1;
            for(int i=0;i<board.length;i++) {
                int doll = board[i][index];
                if(doll != 0) {
                    if(!stack.isEmpty()) {
                        int top = stack.peek();
                        if(top == doll) {
                            stack.pop();
                            answer += 2;
                        }else {
                            stack.push(doll);
                        }
                    }else {
                        stack.push(doll);
                    }
                    board[i][index] = 0;
                    break;
                }
            }
        }
        return answer;
    }

}
