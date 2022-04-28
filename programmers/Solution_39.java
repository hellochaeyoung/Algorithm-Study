package programmers;

import java.util.*;

public class Solution_39 {

    static boolean[] visited;
    static String[] arr;
    static List<String> opList = new ArrayList<>();
    static List<Boolean> checkList = new ArrayList<>();
    static long max = Long.MIN_VALUE;

    public static void main(String[] args) {
        String expression = "50*6-3*2";

        System.out.println(solution(expression));
    }

    public static long solution(String expression) {

        //1. 연산자 우선순위 경우의 수 찾기
        String[] op = {"*", "+", "-"};

        List<String> list = new ArrayList<>();
        for(String s : op) {
            if(expression.contains(s)) {
                list.add(s);
            }
        }

        arr = new String[list.size()];
        visited = new boolean[list.size()];
        find(0, 0, list);

        // 2. 숫자와 연산자 구분하기
        String[] spArr = expression.split("");

        List<String> calc = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<expression.length();i++) {
            if(!spArr[i].matches("^[0-9]*$")) {
                calc.add(sb.toString());
                calc.add(spArr[i]);

                checkList.add(true);
                checkList.add(false);

                sb = new StringBuilder();
            }else {
                sb.append(spArr[i]);
            }
        }

        calc.add(sb.toString());
        checkList.add(true);

        // 3. 중위 수식 -> 후위 수식으로 변환 및 후위 수식 계산
        makeSentence(calc);


        return max;
    }

    static void makeSentence(List<String> list) {

        Stack<String> opStack = new Stack<>();

        // 중위식 -> 후위식으로 변경
        for(String str : opList) { // 우선 순위 경우의 수 마다 값 구하기
            List<String> result = new ArrayList<>();
            for(int i=0;i<checkList.size();i++) {
                if(checkList.get(i)) { // 숫자일 경우
                    result.add(list.get(i)); // 후위식(리스트)에 추가
                }else { // 연산자일 경우
                    if(opStack.isEmpty()) opStack.push(list.get(i));
                    else {
                        int idx = str.indexOf(list.get(i)); // 연산자 우선순위
                        while(!opStack.isEmpty() && str.indexOf(opStack.peek()) >= idx) {
                            result.add(opStack.pop());
                        }
                        opStack.push(list.get(i));
                    }
                }
            }

            while(!opStack.isEmpty()) {
                result.add(opStack.pop());
            }

            // 후위식 계산
            Stack<Long> resultStack = new Stack<>();
            for(String st : result) {
                try {
                    resultStack.push(Long.parseLong(st));
                }catch(Exception e) {
                    Long n2 = resultStack.pop();
                    Long n1 = resultStack.pop();

                    resultStack.push(calc(n1, n2, st));
                }
            }

            // 최댓값 구하기
            max = Long.max(max, Math.abs(resultStack.pop()));
        }

    }

    static long calc(Long n1, Long n2, String op) {

        switch (op) {
            case "*" : return n1*n2;
            case "+" : return n1+n2;
            case "-" : return n1-n2;
        }

        return 0;
    }

    static void find(int depth, int index, List<String> list) {

        if(depth == list.size()) {
            StringBuilder sb = new StringBuilder();
            for(String s : arr) {
                sb.append(s);
            }
            opList.add(sb.toString());
            return;
        }

        for(int i=0;i<list.size();i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[index] = list.get(i);

                find(depth+1,index+1, list);

                visited[i] = false;
            }
        }
    }
}
