package programmers;

import java.util.*;

public class Solution_38 {

    public static void main(String[] args) {
        //handshake, shake hands E=M*C^2 e=m*c^2 aa1+aa2 AAAA12
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        List<String> list1 = toReady(str1);
        List<String> list2 = toReady(str2);

        List<String> copyList = new ArrayList<>(list1);
        List<String> resultList = new ArrayList<>(list1);

        for(String s : list2) {
            if(!copyList.contains(s)) {
                resultList.add(s);
            }else {
                copyList.remove(s);
            }
        }

        List<String> result = new ArrayList<>();
        for(String s : list1) {
            if(list2.contains(s)) {
                list2.remove(s);
                result.add(s);
            }
        }

        double union = resultList.size();
        double intersection = result.size();


        double j = 0;
        if(intersection == 0 && union == 0) { // 둘 다 0일때는 1, 공집합인 경우 0 나올 수 있기 때문에 || 이 아닌 &&!!
            j = 1;
        }else {
            j = intersection / union;
        }

        answer = (int) Math.floor(j*65536);

        return answer;
    }

    static List<String> toReady(String s) {

        List<String> list = new ArrayList<>();

        for(int i=0;i<s.length() - 1;i++) {
            String result = getWords(s, i, i+1);
            if(result.matches("^[a-zA-Z]*$")) {
                result = result.toLowerCase(Locale.ROOT);

                list.add(result);
            }
        }
        return list;
    }

    static String getWords(String s, int from, int to) {
        return s.substring(from, to+1);
    }
}
