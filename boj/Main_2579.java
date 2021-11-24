package boj;

import java.io.*;
import java.util.*;

public class Main_2579 {

    static int stairs = 0;
    static boolean[] visited;
    static int[] scores;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairs = Integer.parseInt(br.readLine());

        visited = new boolean[stairs];

        scores = new int[stairs];
        for(int i=0;i<stairs;i++) {
            int sc = Integer.parseInt(br.readLine());
            scores[i] = sc;
        }

        climb(0,-1, "");

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));

    }

    static void climb(int score, int start, String strs) {

        if(visited[stairs-1]) {
            list.add(score);
            return;
        }

        for(int i=1;i<=2;i++) {
            int loc = start+i;
            strs += i;

            if(loc > stairs-1) {
                return;
            }

            if(strs.contains("111")) {
                return;
            }

            visited[loc] = true;
            score += scores[loc];
            climb(score, loc, strs);

            score -= scores[loc];
            strs = strs.substring(0,strs.length()-1);
            visited[loc] = false;
        }

        return;
    }
}
