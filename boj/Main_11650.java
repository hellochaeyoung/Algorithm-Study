package boj;

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_11650 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x,y));
        }

        /* 1. 람다식 사용
        Collections.sort(list, (Point p1, Point p2) -> {
            if(p1.x == p2.x) {
                return p1.y - p2.y;
            }else {
                return p1.x - p2.x;
            }
        });
         */

        // 2. Comparator 익명 객체 구현
        Collections.sort(list, new Comparator<Point>() { // 익명 객체(클래스) 사용
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Point p : list) {
            sb.append(p.x + " " + p.y + "\n");
        }

        System.out.println(sb);
    }
}
