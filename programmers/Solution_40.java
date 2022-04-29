package programmers;

import java.util.*;

public class Solution_40 {

    public static void main(String[] args) {
        String s = "{{20,111},{111}}";

        System.out.println(solution(s).toString());

        otherSolution(s);
    }
    public static List<Integer> solution(String s) {
        int[] answer = {};

        s = s.substring(1, s.length()-1);
        s = s.replaceAll("},", " ");
        s = s.replaceAll("}", "");

        String[] arr = s.split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[100001];

        for(String st : arr) {
            st = st.substring(1);
            String[] tempArr = st.split(",");

            for(String str : tempArr) {
                int idx = Integer.parseInt(str);
                if(!check[idx]) {
                    check[idx] = true;

                    list.add(idx);
                }
            }
        }

        return list;
    }

    static int[] otherSolution(String s) {

        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, Comparator.comparing(String::length));

        int[] answer = new int[arr.length];
        int idx = 0;

        for(String st : arr) {
            for(String str : st.split(",")) {
                if(set.add(str)) answer[idx++] = Integer.parseInt(str);
            }
        }

        return answer;
    }
}
