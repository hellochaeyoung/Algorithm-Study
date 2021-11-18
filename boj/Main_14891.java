package boj;

import java.io.*;
import java.util.*;

public class Main_14891 {

    static final int count = 4;
    static final int state = 8;

    static ArrayList<Integer> first = new ArrayList<>();
    static ArrayList<Integer> second = new ArrayList<>();
    static ArrayList<Integer> third = new ArrayList<>();

    static ArrayList<Character> stateList = new ArrayList<>();
    static ArrayList<ArrayList<Character>> list = new ArrayList<>();

    static boolean[] impossible;
    static int[] rotation;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<count;i++) {
            String str = br.readLine();
            for(int j=0;j<state;j++) {
                stateList.add(str.charAt(j));
            }
            list.add(stateList);
        }

        impossible = new boolean[list.size()];
        rotation = new int[list.size()];
        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rotationOfWheel = Integer.parseInt(st.nextToken()); // 회전할 바퀴
            int direction = Integer.parseInt(st.nextToken()); // 회전할 바퀴의 회전 방향
        }
    }

    static void check(int numberOfWheel, int direction) {

        // 기준 바퀴의 위치가 홀수냐 짝수냐, 시계/반시계방향이냐에 따라서 달라짐
        boolean even;
        if(numberOfWheel % 2 == 0) {
            even = true;
        }else {
            even = false;
        }

        for(int i=0;i<list.size()-1;i++) {

            if(i % 2 == 0) { // 위치가 짝수면
                if(even) { // 기준 바퀴의 위치가 짝수면
                    rotation[i] = direction; // 짝수 인덱스는 다 동일 direction
                }else { // 기준 바퀴의 위치가 홀수면
                    if(direction > 0) {
                        rotation[i] = direction - 2;
                    }else {
                        rotation[i] = direction + 2;
                    }
                }
            }else { // 위치가 홀수면
                if(even) {
                    if(direction > 0) {
                        rotation[i] = direction - 2;
                    }else {
                        rotation[i] = direction + 2;
                    }
                }else {
                    rotation[i] = direction;
                }
            }
            int right = list.get(i).get(2);
            int left = list.get(i+1).get(6);

            if(right == left) { // 다음 바퀴의 톱니의 극과 같으면
                impossible[i] = true; // 회전이 불가능한 바퀴
                // 회전할 바퀴 위치와 회전 방향에 따라서 나머지 바퀴들의 회전 방향이 결정됨

                rotation[i] = 0; // 회전하지 않을 바퀴
            }
        }

    }

    static void rotate() {

        for(int i=0;i<list.size();i++) {
            if(rotation[i] == 1) { // 시계 뱡항
                
            }else if(rotation[i] == -1) { // 반시계 방향

            }else { // 회전 안함

            }
        }
    }
}
