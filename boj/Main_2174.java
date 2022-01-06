package boj;

import java.io.*;
import java.util.*;

class Robot {
    int n, x, y;
    String d;

    public Robot(int n, int x, int y, String d) {
        this.n = n;
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Order {
    int robotNumber, count;
    String order;

    public Order(int robotNumber, String order, int count) {
        this.robotNumber = robotNumber;
        this.order = order;
        this.count = count;
    }
}

public class Main_2174 {

    static int A,B;
    static int[][] map;

    // 위, 오, 아래, 왼
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static String dir = "NESW";

    static ArrayList<Robot> robots = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[B+1][A+1];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            Robot robot = new Robot(i+1, x, y, d);
            robots.add(robot);
            map[y][x] = i+1;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int robotNumber = Integer.parseInt(st.nextToken());
            String order = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            orders.add(new Order(robotNumber, order, count));
        }

        while(!orders.isEmpty()) {
            Order o = orders.remove(0);

            int n = o.robotNumber;
            String order = o.order;
            int count = o.count;

            for(int i=0;i<count;i++) {
                move(n, order);
            }
        }

        System.out.println("OK");

    }

    static void move(int n, String o) {

        Robot robot = robots.get(n-1);

        if(!o.equals("F")) {
            robot.d = getDirection(robot.d, o);
        }else {
            String d = robot.d;
            int index = dir.indexOf(d);

            int x = robot.x;
            int y = robot.y;

            int nx = x + dx[index];
            int ny = y + dy[index];

            if(nx <= 0 || nx > A || ny <= 0 || ny > B) {
                System.out.println("Robot " + n + " crashes into the wall");
                System.exit(0);
            }

            if(map[ny][nx] == 0) {
                map[y][x] = 0;
                robot.x = nx;
                robot.y = ny;
                map[ny][nx] = robot.n;
            }else {
                int exist = map[ny][nx];
                System.out.println("Robot " + n + " crashes into robot " + exist);
                System.exit(0);
            }

        }
    }

    static String getDirection(String d, String o) {

        switch (d) {

            case "W" : {
                if(o.equals("L")) {
                    return "S";
                }else {
                    return "N";
                }
            }

            case "E" : {
                if(o.equals("L")) {
                    return "N";
                }else {
                    return "S";
                }
            }

            case "S" : {
                if(o.equals("L")) {
                    return "E";
                }else {
                    return "W";
                }
            }

            case "N" : {
                if(o.equals("L")) {
                    return "W";
                }else {
                    return "E";
                }
            }

        }
        return "";
    }
}
