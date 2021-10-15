package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2529 {

    static String[] input; // 부등호 입력 저장 배열
    static boolean[] check = new boolean[10]; // 중복 숫자 피하기 위한 check 배열
    static int[] numbers; // 선택된 숫자 저장할 배열
    static ArrayList<String> list = new ArrayList<>(); // 최종 수를 저장할 리스트
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        input = new String[k];
        numbers = new int[k+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++) {
            input[i] = st.nextToken();
        }

        for(int i=0;i<10;i++) {
            dfs(i,0);
            check = new boolean[10]; // 다시 false로 초기화
        }

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));


    }

    static void dfs(int pre, int depth) {

        if(depth == k+1) {
            String s = "";
            for(int i=0;i<numbers.length;i++) {
                s += numbers[i];
            }
            list.add(s);
            return;
        }

        // 부등호 처리
        String comparator = "";
        if(depth == 0) { // 0일 경우 그대로
            comparator = input[depth];
        }else { // 아닐 경우 depth 보다 -1의 부등호를 사용
            comparator = input[depth-1];
        }


        // 부등호는 부등호를 기준으로 왼쪽인지 오른쪽인지 위치에 따라 정반대가 됨
        // 이 문제에서는 부등호 오른쪽 위치의 숫자를 기준으로 했으므로 > 일때 보다 작은 숫자들을 탐색
        // < 일때 보다 큰 숫자들을 탐색
        if(comparator.equals(">")) {
            for(int i=0;i<=pre;i++) { //
                if(!check[i]) {
                    check[i] = true;
                    numbers[depth] = i;
                    dfs(i,depth+1);

                    check[i] = false;
                }
            }

        }else {
            for(int i=pre;i<=9;i++) {
                if(!check[i]) {
                    check[i] = true;
                    numbers[depth] = i;
                    dfs(i,depth+1);

                    check[i] = false;
                }
            }
        }
        return;
    }
}
