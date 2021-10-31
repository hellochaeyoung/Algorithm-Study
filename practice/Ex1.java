package practice;

import java.util.*;

public class Ex1 {

    public static void main(String[] args) {

        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};

        int k = 3;

        int answer = solution(id_list, k);

        System.out.println(answer);
    }

    public static int solution(String[] id_list, int k) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<id_list.length;i++) {
            String[] arr = id_list[i].split("\\s");

            // 중복값 없애기 위해서 Array -> Set -> Array로 변환하는 과정 거침침
           HashSet<String> set = new HashSet<>(Arrays.asList(arr));
            String[] result = set.toArray(new String[0]);

            for(int j=0;j<result.length;j++) {
                String key = result[j];
                if(map.containsKey(key) && map.get(key) == k) {
                    continue;
                }
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        for(String key : map.keySet()) {
            answer += map.get(key);
        }

        return answer;
    }
}
