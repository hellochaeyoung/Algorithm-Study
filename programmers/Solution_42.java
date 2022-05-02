package programmers;

import java.util.*;

public class Solution_42 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, List<int[]>> map = new HashMap<>();
        TreeMap<String, Integer> countMap = new TreeMap<>();

        for(int i=0;i< genres.length;i++) {
            if(map.containsKey(genres[i])) {
                map.get(genres[i]).add(new int[] {i, plays[i]});
            }else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[] {i, plays[i]});
                map.put(genres[i], list);
            }

            countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(countMap.entrySet());
        entryList.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        for(List<int[]> list : map.values()) {
            list.sort((o1, o2) -> {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            });
        }

        List<Integer> resultList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            String key = entry.getKey();
            List<int []> value = map.get(key);
            if(value.size() == 1) {
                resultList.add(value.get(0)[0]);
            }else {
                resultList.add(value.get(0)[0]);
                resultList.add(value.get(1)[0]);
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
