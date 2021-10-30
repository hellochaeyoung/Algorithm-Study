package practice;

import java.util.*;


public class Ex2 {

    public static void main(String[] args ) {

        String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};

        //Arrays.sort(logs);



        String[] answer = solution(logs);

        for(int i=0;i<answer.length;i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static String[] solution(String[] logs) {
        String[] answer = {};

        Map<String, String> map = new HashMap<>();

        Arrays.sort(logs);

        for(int t=0;t< logs.length;t++) {
            System.out.println(logs[t]);
        }

        String totalKey = "";
        String totalValue = "";

        for(int i=0;i<logs.length;i++) {
            String[] arr = logs[i].split("\\s");
            System.out.println(arr[0] + arr[1] + arr[2]);
            String key = arr[0] + "-" + arr[1];
            map.put(key, arr[2]);
        }

        String pre = "";

        Map<String, String> map2 = new HashMap<>();



        for(String key : map.keySet()) {
            if( !pre.equals(key.split("-")[0]) ) {
                String s = totalKey + totalValue;
                map2.put(s, map.getOrDefault(s, "") + " " + pre);
                totalKey = "";
                totalValue = "";
            }
            String k = key.split("-")[1];
            totalKey += k;
            totalValue += map.get(key);

            pre = key.split("-")[0];
            System.out.println(pre);
        }

        ArrayList<String> list = new ArrayList<>();

        for(String key : map2.keySet()) {
            String value = map2.get(key);
            if(value.length() > 8) {
                String[] values = value.split(" ");
                for(int i=0;i<values.length;i++) {
                    list.add(values[i]);
                }
            }
        }

        Collections.sort(list);
        answer = list.toArray(new String[0]);

        return answer;
    }
}
