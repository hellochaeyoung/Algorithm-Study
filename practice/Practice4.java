package practice;

import java.awt.*;

public class Practice4 {

    static int[] result = {0,0,0};
    static boolean[] player;

    public static void main(String[] args) {

        String[] rsp3 = {"SPR","PPR","PSS","RSS","RRR"};
        //String[] rsp3 = {"RRR", "SPS"};

        for(String s : rsp3) {
            spr(s);
        }

        for(int i : result) {
            System.out.print(i + " ");
        }
    }

    static void spr(String s) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char c3 = s.charAt(2);

        player = new boolean[3];

        int winner = 0;

        int result = game(c1, c2);
        if(result > 0) {
            winner++;
            player[0] = true;
        }else if(result < 0) {
            winner++;
            player[1] = true;
        }

        result = game(c2, c3);
        if(result > 0) {
            winner++;
            player[1] = true;
        }else if(result < 0) {
            winner++;
            player[2] = true;
        }

        result = game(c3, c1);
        if(result > 0) {
            winner++;
            player[2] = true;
        }else if(result < 0) {
            winner++;
            player[0] = true;
        }

        score(winner);
    }

    static void score(int winner) {

        if(winner == 1) {
            for(int i=0;i<3;i++) {
                if(player[i]) {
                    result[i] += 2;
                }
            }
        }else if(winner == 2) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            boolean check = false;

            for(int i=0;i<3;i++) {
                if(player[i]) {
                    if(min > result[i]) {
                        index = i;
                        min = result[i];
                    }else if(min == result[i]) {
                        result[index]++;
                        result[i]++;
                        check = true;
                    }
                }
            }

            if(!check) {
                result[index] += 2;
            }
        }
    }

    static int game(char c1, char c2) {

        if(c1 == 'S') {
            if(c2 == 'P') {
                return 1;
            }else if(c2 == 'R') {
                return -1;
            }
        }else if(c1 == 'P') {
            if(c2 == 'S') {
                return -1;
            }else if(c2 == 'R'){
                return 1;
            }
        }else {
            if(c2 == 'S') {
                return 1;
            }else if(c2 == 'P') {
                return -1;
            }
        }

        return 0;
    }
}
