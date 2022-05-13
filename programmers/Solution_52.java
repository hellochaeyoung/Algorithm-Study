package programmers;

import java.util.*;

public class Solution_52 {

    static boolean[] check;
    static Set<String> set;
    static String[] temp;

    static int N;
    static String[] arr;

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        solution(relation);

        System.out.println(list.toString());
    }

    public static int solution(String[][] relation) {
        int answer = 0;


        set = new HashSet<>();
        temp = new String[relation[0].length];

        arr = new String[relation[0].length];

        N = relation[0].length;
        check = new boolean[N];

        for(int i=0;i<N;i++) {
            dfs(i+1, 0, 0);
        }

        return answer;
    }

    static void dfs(int depth, int count, int start) {

        if(count == depth) {
            StringBuilder sb = new StringBuilder();
            for(String n : arr) {
                if(n == null) break;
                sb.append(n);
            }
            list.add(sb.toString());
            return;
        }

        for(int i=start;i<N;i++) {
            if(!check[i]) {
                check[i] = true;

                arr[count] = String.valueOf(i);
                dfs(depth, count+1, start++);

                check[i] = false;
            }
        }
    }

    static void find(String[][] relations) {

        List<String> onlyList = new ArrayList<>();

        for(String s : list) {
            //boolean duplicated = false;
            String[] arr = s.split("");

            Set<String> set = new HashSet<>();
            for(int i=0;i< relations.length;i++) {
                StringBuilder sb = new StringBuilder();

                for (String value : arr) {
                    int idx = Integer.parseInt(value);
                    sb.append(relations[i][idx]);
                }

                if (!set.add(sb.toString())) {
                    break;
                }

                onlyList.add(s);
            }
        }
    }
}
