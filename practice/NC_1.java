package practice;

import java.util.*;

public class NC_1 {

    public static void main(String[] args) {
        String[] movie = {"spy","ray","spy","room","once","ray","spy","once"};

        System.out.println(Arrays.toString(solution(movie)));
    }

    public static String[] solution(String[] movie) {

        Map<String, Integer> map = new HashMap<>();

        for(String m : movie) {
            map.put(m, map.getOrDefault(m, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}
