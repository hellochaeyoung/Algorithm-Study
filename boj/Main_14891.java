package boj;

import java.io.*;
import java.util.*;

public class Main_14891 {

    static final int count = 4;
    static final int state = 8;

    static ArrayList<Character> stateList;
    static ArrayList<ArrayList<Character>> list = new ArrayList<>();

    static int[] rotation;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<count;i++) {
            stateList = new ArrayList<>(); // 매번 새로 생성해줘야 초기화됨, 이것 생각못하고 그대로 add해서 잘못 입력 들어감.
            String str = br.readLine();
            for(int j=0;j<state;j++) {
                stateList.add(str.charAt(j));
            }
            list.add(stateList);
        }

        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rotationOfWheel = Integer.parseInt(st.nextToken()); // 회전할 바퀴
            int direction = Integer.parseInt(st.nextToken()); // 회전할 바퀴의 회전 방향

            rotation = new int[count]; // 회천 바퀴와 방향에 따라서 모든 바퀴들의 회전 방향과 여부가 정해지므로 매번 새로 생성하여 초기화

            check(rotationOfWheel-1, direction);

            rotate();
        }

        System.out.println(getScore());

    }

    //재귀호출로 해결하는 방법 생각해내지 못함!!!!
    static void check(int numberOfWheel, int direction) {

        rotation[numberOfWheel] = direction;

        int prev = numberOfWheel - 1;
        int next = numberOfWheel + 1;

        if(prev >= 0 && rotation[prev] == 0) {
            if(list.get(prev).get(2) != list.get(numberOfWheel).get(6)) {
                check(prev, direction * -1); //
            }
        }

        if(next <= 3 && rotation[next] == 0) {
            if(list.get(next).get(6) != list.get(numberOfWheel).get(2)) {
                check(next, direction * -1); //
            }
        }

    }

    static void rotate() {

        for(int i=0;i<count;i++) {
            int size = state-1;
            if(rotation[i] == 1) { // 시계 뱡항
                char last = list.get(i).remove(size);
                list.get(i).add(0, last);
            }else if(rotation[i] == -1) { // 반시계 방향
                char first = list.get(i).remove(0);
                list.get(i).add(first);
            }else { // 회전 안함
                continue;
            }
        }
    }

    static int getScore() {
        int score = 0;

        for(int i=0;i<list.size();i++) {
            char ch = list.get(i).get(0);
            if(i == 0 && ch == '1') {
                score += 1;
            }else if(i == 1 && ch == '1') {
                score += 2;
            }else if(i == 2 && ch == '1') {
                score += 4;
            }else if(i == 3 && ch == '1') {
                score += 8;
            }
        }
        return score;
    }
}
