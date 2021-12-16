package boj;

import java.util.*;
import java.io.*;

public class Main_1018 {

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;
    static boolean[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<M;j++) {
                if(line.charAt(j) == 'W') { // 문자 기준으로 boolean값 저장
                   board[i][j] = true;
                }else {
                    board[i][j] = false;
                }
            }
        }

        int row = N - 7;
        int col = M - 7;

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                getMin(i,j);
            }
        }

        System.out.println(min);
    }

    static void getMin(int x, int y) {

        int endX = x+8;
        int endY = y+8;

        int count = 0;

        boolean st = board[x][y]; // 색칠 경우의 수는 두 가지이므로 처음값에 따라 색칠할 개수가 정해짐
        for(int i=x;i<endX;i++) {
            for(int j=y;j<endY;j++) {

                if(board[i][j] != st) {
                    count++;
                }

                st = (!st); // 이 부분이 핵심, 처음에 문제풀 때는 두 가지의 색칠 경우의 수를 다 저장해야 한다고 생각 -> 비효율적, 단지 true, false인지만 따져주면 됨
            }

            st = !st; // 이 부분이 핵심
        }

        count = Math.min(count, 64-count); // 위에서 'W'로만 해서 해도 되는게 이것 때문, 반대 알파벳 시작 경우의 수는 전체에서 첫번째 알파벳 시작 색칠 카운트를 빼면 됨

        min = Math.min(min, count);

    }


}

