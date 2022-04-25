package programmers;

import java.util.PriorityQueue;

public class Solution_33 {

    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n : scoville) {
            heap.add(n);
        }

        while(heap.peek() < K) {

            if(heap.size() < 2) {
                return -1;
            }

            answer++;

            int n1 = heap.poll();
            int n2 = heap.poll();

            int newScoville = n1 + (n2 * 2);

            heap.add(newScoville);

        }
        return answer;
    }
}
