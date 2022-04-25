package programmers;

import java.util.*;

public class Solution_34 {

    static StringBuilder sb;
    static Map<String, Integer> map;

    public static void main(String[] args) {

        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};

        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for(int i=0;i<orders.length;i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        List<String> list = new ArrayList<>();

        for(int i=0;i< course.length;i++) {

            map = new HashMap<>();
            int max = Integer.MIN_VALUE;

            for(int j=0;j< orders.length;j++) {
                String[] arr = orders[j].split("");
                sb = new StringBuilder();
                if(course[i] <= orders[j].length()) {
                    dfs(arr, 0, 0, course[i]);
                }
            }

            for(String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }

            for(String key : map.keySet()) {
                if(max >= 2 && max == map.get(key)) {
                    list.add(key);
                }
            }
        }

        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    static void dfs(String[] arr, int start, int depth, int cnt) {

        if(depth == cnt) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for(int i=start;i<arr.length;i++) {
            sb.append(arr[i]);

            dfs(arr, i+1, depth+1, cnt);

            sb.delete(depth, depth+1);
        }
    }
}
