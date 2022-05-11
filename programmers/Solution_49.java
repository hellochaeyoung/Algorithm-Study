package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_49 {

    public static void main(String[] args) {
        String name = "BBBBAAAABA";

        System.out.println(solution(name));
    }
    public static int solution(String name) {

        List<String> list = new ArrayList<>();
        for(char c='A';c<='Z';c++) {
            list.add(String.valueOf(c));
        }

        List<Integer> result = new ArrayList<>();

        String[] arr = name.split("");
        int cnt = 0;
        for(int i=0;i<arr.length;i++) {

            if(arr[i].equals("A")) {
                int end = countMove(i, arr);
                int move = (i-1) + (arr.length - (end + 1));

                //int move2 = 2 * (arr.length - (end+1)) + i;
                for(int j=end+1;j<arr.length;j++) {
                    move += Math.min(list.indexOf(arr[j]), 26 - list.indexOf(arr[j]));
                }
                result.add(cnt + move - 1);
            }

            int idx = list.indexOf(arr[i]);

            int reverseIdx = 26 - idx;
            idx = Math.min(reverseIdx, idx);
            cnt += idx;

            cnt++;
        }

        result.add(cnt - 1);

        Collections.sort(result);

        return result.get(0);
    }

    static int countMove(int start, String[] arr) {

        int end = start;
        for(int i=start;i<arr.length;i++) {
            if(arr[i].equals("A")) end = i;
            else break;
        }

        return end;
    }

    static int otherSolution(String name) {
        int answer = 0;

        int len = name.length();
        int index;
        int move = len - 1;

        for(int i=0;i<len;i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i+1;

            while(index < len && name.charAt(index) == 'A'){
                index++;
            }

            move = Math.min(move, i * 2 + len - index);

            move = Math.min(move, (len - index) * 2 + i);
        }

        return answer + move;
    }
}
