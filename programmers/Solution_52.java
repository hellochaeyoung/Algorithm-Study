package programmers;

import java.util.*;

public class Solution_52 {

    static int N;
    static boolean[] check;
    static String[] arr;
    static boolean[] isPrimary;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        solution(relation);
    }

    public static int solution(String[][] relation) {
        int answer = 0;

        N = relation[0].length;
        isPrimary = new boolean[N];
        arr = new String[N];
        check = new boolean[N];

        for(int i=0;i<N;i++) {
            dfs(i+1, 0, 0);
        }

        System.out.println(list.toString());

        List<String> noDuplicatedList = find(relation);
        System.out.println(noDuplicatedList.toString());
/*
        Iterator<String> iterator = noDuplicatedList.iterator();
        for(int i=0;i< isPrimary.length;i++) {
            if(isPrimary[i]) {
                while(iterator.hasNext()) {
                    String st = iterator.next();
                    if(st.length() != 1 && st.contains(String.valueOf(i))) {
                        iterator.remove();
                    }
                }
            }
        }

 */

        List<String> finalList = new ArrayList<>(noDuplicatedList);
        for(int i=0;i<noDuplicatedList.size()-1;i++) {
            String st = noDuplicatedList.get(i);
            for(int j=i+1;j<noDuplicatedList.size();j++) {
                String next = noDuplicatedList.get(j);
                if(next.startsWith(st)) finalList.remove(next);
            }
        }

        System.out.println(finalList.toString());



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
                dfs(depth, count+1, i+1);

                check[i] = false;
            }
        }
    }

    static List<String> find(String[][] relations) {

        List<String> onlyList = new ArrayList<>();

        for(String s : list) {
            boolean duplicated = false;
            String[] arr = s.split("");

            Set<String> set = new HashSet<>();
            for(int i=0;i< relations.length;i++) {
                StringBuilder sb = new StringBuilder();

                for (String value : arr) {
                    int idx = Integer.parseInt(value);
                    sb.append(relations[i][idx]);
                }

                if (!set.add(sb.toString())) {
                    duplicated = true;
                    break;
                }
            }

            if(!duplicated) {
                if(s.length() == 1) {
                    int idx = Integer.parseInt(s);
                    isPrimary[idx] = true;
                }
                onlyList.add(s);
            }
        }

        return onlyList;
    }

}
