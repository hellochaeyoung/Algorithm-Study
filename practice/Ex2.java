package practice;

import java.util.*;


public class Ex2 {

    // 제출한 문제번호와 점수가 다 동일해야 함
    // 여러 번 제출 가능하며 가장 마지막에 제출한 점수가 문제의 최종 점수가 됨
    // 시간 내에 해결하지 못했던 요인 : 해시맵의 특징을 정확하게 알고 있지 않았음, 정렬을 했을 시 최종점수 순서가 뒤바껴 잘못 저장될 수 있다는 점을 파악하지 못함

    // 로직 : 1. TreeMap에 학생번호-문제번호 라는 키 값으로 점수 저장하여 최종 점수로 1차 선별
    //       2. 학생번호 마다 제출한 문제와 점수가 5문제 이상일 경우에만 해시맵에 학생번호를 저장
    //       3. 동일한 키(제출한 문제 종류와 점수들)에 저장된 학생들 2명 이상일 경우 리스트에 저장하여 오름차순으로 출력
    // => 이보다 더 간단한 로직이 있을 거 같은데 생각이 안남...,, 문제와 점수가 다 동일해야하기 때문에 합계라던지 다른 방법으로 비교할 수가 없음, 정렬하여 다 이어붙인 문자열 값으로 비교하는 방법으로 풀이..
    public static void main(String[] args ) {

        String[] logs = {"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"};
        //String[] logs = {"0001 5 60", "0001 9 90", "0002 1 20", "0003 5 60"};

        String[] answer = solution(logs);

        if (answer.length == 0) {
            System.out.println("None");
            return;
        }

        for(int i=0;i<answer.length;i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static String[] solution(String[] logs) {
        String[] answer = {};

        Map<String, String> treeMap = new TreeMap<>();
        // TreeMap은 자동으로 key 값 기준으로 정렬해준다!!
        // HashMap은 put할 때 해시값을 이용하기 때문에 순서 유지가 안된다. 따라서 따로 정렬해주는 기능 구현이 필요하다.
        // 추가하는 순서를 유지하고 싶다면 LinkedHashMap을 사용하는 것이 좋다.


        // key : 학생번호-문제번호, value : 점수로 저장 - key값 기준으로 오름차순 정렬로!
        for(int i=0;i<logs.length;i++) {

            String[] arr = logs[i].split("\\s");

            String key = arr[0] + "-" + arr[1];

            treeMap.put(key, arr[2]);
        }

        Map<String, String> map = new HashMap<>();

        String totalKey = ""; // 제출한 문제 번호 종류를 저장하는 변수
        String totalValue = ""; // 제출한 문제의 점수를 저장하는 변수
        String pre = ""; // 학생번호를 저장하는 변수
        int count = 0; // 문제 개수 저장하는 변수

        for(String key : treeMap.keySet()) {

            // 학생번호-문제번호 순으로 정렬되어있기 때문에 새로운 학생번호가 나오면 그동안 저장해둔 (문제번호 + 점수들)를 키 값으로 하여 학생번호를 해시맵에 저장한다. -> 문제종류와 문제점수가 다 동일한 사람을 찾아야하기 때문에
            // 오름차순으로 정렬해두었기 때문에 문제와 점수가 동일하다면 동일한 키에 학생번호가 추가로 저장된다.
            if( pre != "" && !pre.equals(key.split("-")[0]) ) {

                String s = totalKey + totalValue;
                if(count >= 5) { // 5문제 이상 동일한 경우만
                    map.put(s, map.getOrDefault(s, "") + pre + " ");
                }

                totalKey = ""; // 다음 학생의 문제번호를 저장하기 위해 초기화
                totalValue = ""; // 다음 학생의 점수들을 저장하기 위해 초기화
                count = 0;
            }

            String k = key.split("-")[1];
            totalKey += k;
            totalValue += treeMap.get(key);
            count++;

            pre = key.split("-")[0];


        }

        ArrayList<String> list = new ArrayList<>();

        for(String key : map.keySet()) {
            String value = map.get(key);

            // 두 명 이상의 학생의 번호가 저장되었다면 부정행위자들이므로 리스트에 추가
            if(value.length() > 8) {
                String[] values = value.split(" ");
                for(int i=0;i<values.length;i++) {
                    list.add(values[i]);
                }
            }
        }

        // 학생번호를 오름차순으로 출력해야 하므로 정렬
        Collections.sort(list);
        answer = list.toArray(new String[0]);

        return answer;
    }
}
