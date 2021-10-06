package boj;

import java.io.*;
import java.util.*;

public class Main_1085 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int width = getWidthDistance(x,w);
        int height = getHeightDistance(y,h);

        printMinDistance(width, height);
    }

    public static int getWidthDistance(int x, int w) {

        int distance = 0;

        if(x <= w/2) {
            distance = x;
        }else {
            distance = w-x;
        }

        return distance;
    }

    public static int getHeightDistance(int y, int h) {

        int distance = 0;

        if(y <= h/2) {
            distance = y;
        }else {
            distance = h-y;
        }

        return distance;
    }

    public static void printMinDistance(int n, int m) {
        if(n <= m) {
            System.out.println(n);
        }else {
            System.out.println(m);
        }
    }
}
