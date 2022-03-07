package programmers;

import java.util.*;

public class Solution_1 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<Integer>> list = new HashMap<>();

        for(int i=0;i< id_list.length;i++) {
            map.put(id_list[i], i);
        }

        for(String str : report) {
            String user = str.split(" ")[0]; // 신고자
            String name = str.split(" ")[1]; // 신고받은자

            List<Integer> subList;
            if(!list.containsKey(name)) { // 이미 신고당한 사람이 아니면
                subList = new ArrayList<>();
            }else {
                subList = list.get(name);
            }

            if(!subList.contains(map.get(user))) { // 동일 신고자의 신고 피하기 위해
                subList.add(map.get(user));
                list.put(name, subList);
            }

        }

        for(String key : list.keySet()) {
            if(list.get(key).size() >= k) { // k명 이상의 신고자를 갖고있다면
                for(int i : list.get(key)) {
                    answer[i]++; // 신고자 인덱스에 카운트
                }
            }
        }

        return answer;
    }
}
