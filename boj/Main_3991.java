package boj;

import java.util.*;
import java.io.*;

public class Main_3991 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] game = new int[h][w];
        int[] bead = new int[c];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++) {
            bead[i] = Integer.parseInt(st.nextToken());
        }

        int row = 0;
        int col = 0;
        int now = 1;
        //int index = 0;
        boolean isReverse = false;

        for(int i=0;i<c;i++) {
            while(true) {

                if(bead[i] == 0) {
                    break;
                }

                if(col == w) { // 배열 범위를 벗어났다면
                    col = w-1;
                    row++;
                    isReverse = true;
                }

                if(col < 0) { // 배열 범위를 벗어났다면
                    col = 0;
                    row++;
                    isReverse = false;
                }

                game[row][col] = now;

                if(isReverse) {
                    col--;
                }else {
                    col++;
                }

                bead[i]--;

            }

            now++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                sb.append(game[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}
