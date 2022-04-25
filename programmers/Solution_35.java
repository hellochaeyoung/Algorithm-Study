package programmers;

import java.util.*;

public class Solution_35 {

    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        System.out.println(solution(n,k,cmd));
    }

    public static String solution(int n, int k, String[] cmd) {

        int[] pre = new int[n];
        int[] next = new int[n];

        for(int i=0;i<n;i++) {
            pre[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1; /////////////////////

        Stack<int[]> stack = new Stack<>();

        for(String c : cmd) {
            if(c.equals("C")) {
                stack.push(new int[]{pre[k], k, next[k]});

                if(pre[k] != -1) next[pre[k]] = next[k];
                if(next[k] != -1) pre[next[k]] = pre[k];

                if(next[k] != -1) k = next[k];
                else k = pre[k];

            }else if(c.equals("Z")) {
                int[] arr = stack.pop();

                if(arr[0] != -1) next[arr[0]] = arr[1];
                if(arr[2] != -1) pre[arr[2]] = arr[1];

            }else {
                String order = c.split(" ")[0];
                int move = Integer.parseInt(c.split(" ")[1]);

                if(order.equals("U")) {
                    while(move-- > 0) {
                        k = pre[k];
                    }
                }else if(order.equals("D")) {
                    while(move-- > 0) {
                        k = next[k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append('O');
        }

        for(int[] arr : stack) {
            int idx = arr[1];
            sb.setCharAt(idx, 'X');
        }

        return sb.toString();
    }

}
