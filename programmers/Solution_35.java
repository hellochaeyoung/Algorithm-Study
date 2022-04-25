package programmers;

import java.util.*;

public class Solution_35 {

    static PriorityQueue<Integer> queue;

    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        System.out.println(solution(n,k,cmd));
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        queue = new PriorityQueue<>();
        List<Integer> list = new LinkedList<>();
        Stack<int[]> stack = new Stack<>();

        for(int i=0;i<n;i++) {
            list.add(i);
        }

        for(String c : cmd) {
            if(c.equals("C")) {
                int size = list.size(); // 삭제하기 전 길이
                int num = list.remove(k);
                stack.push(new int[]{k, num});

                if(k == size - 1) {
                    k = list.size() - 1; // 삭제 후 길이
                }
            }else if(c.equals("Z")) {
                int[] removed = stack.pop();
                if(removed[0] <= k) {
                    k += 1;
                }
                list.add(removed[0], removed[1]);
            }else {
                String order = c.split(" ")[0];
                int move = Integer.parseInt(c.split(" ")[1]);

                if(order.equals("U")) {
                    k -= move;
                }else if(order.equals("D")) {
                    k += move;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append('O');
        }

        for(int[] arr : stack) {
            int idx = arr[0];
            sb.setCharAt(idx, 'X');
        }

        return sb.toString();
    }

}
