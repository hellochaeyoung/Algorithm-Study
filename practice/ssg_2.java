package practice;

import java.util.*;

public class ssg_2 {

    public static void main(String[] args) {
        //String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};

        String[] logs = {"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"};
        System.out.println(Arrays.toString(solution(logs)));
    }
    public static String[] solution(String[] logs) {

        String[] answer = {};

        Map<String, TreeMap<String, String>> map = new HashMap<>();

        for(String s : logs) {
            String[] arr = s.split(" ");
            if(!map.containsKey(arr[0])) {
                map.put(arr[0], new TreeMap<>());
            }
            map.get(arr[0]).put(arr[1], arr[2]);
        }

        System.out.println(map.toString());

        Map<String, List<String>> resultMap = new HashMap<>();
        for(String key : map.keySet()) {
            TreeMap<String, String> treeMap = map.get(key);

            if(treeMap.size() > 4) {
                String k = treeMap.toString();
                if(!resultMap.containsKey(k)) {
                    resultMap.put(k, new ArrayList<>());
                }
                resultMap.get(k).add(key);
            }
        }

        List<String> finalList = new ArrayList<>();
        for(List<String> list : resultMap.values()) {
            if(list.size() > 1) {
                finalList.addAll(list);
            }
        }

        if(finalList.isEmpty()) {
            return new String[] {"None"};
        }

        Collections.sort(finalList);

        return finalList.toArray(new String[0]);
    }
}
