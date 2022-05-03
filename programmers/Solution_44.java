package programmers;

import java.util.*;

public class Solution_44 {

    static String[] information;
    static String[] arr;
    static Map<String, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
    public static int[] solution(String[] info, String[] query) {

        information = info;
        arr = new String[4];

        for(String s : info) {
            String[] temp = s.split(" ");
            dfs(0,temp);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        List<Integer> resultList = new ArrayList<>();

        for(String st : query) {
            st = st.replaceAll(" and", ",");
            int idx = st.lastIndexOf(" ");

            String key =  "[" + st.substring(0, idx) + "]";
            int score = Integer.parseInt(st.substring(idx+1));

            int cnt = search(key, score);

            resultList.add(cnt);
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    static void dfs(int depth, String[] temp) {

        if(depth == 4) {
            String key = Arrays.toString(arr);
            int score = Integer.parseInt(temp[temp.length-1]);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(score);
            return;
        }

        arr[depth] = temp[depth];
        dfs(depth+1, temp);

        arr[depth] = "-";
        dfs(depth+1, temp);
    }

    static int search(String key, int score) {
        if(!map.containsKey(key)) return 0;

        List<Integer> list = map.get(key);
        int start = 0, end = list.size()-1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < score) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }
}
