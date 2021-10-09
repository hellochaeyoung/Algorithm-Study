package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002 {

    public static int x1;
    public static int y1;
    public static int x2;
    public static int y2;
    public static int r1;
    public static int r2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());


            double sumRadius = r1+r2;

            checkSize(); // 중심이 음수일 경우 처리위해
            double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));

            if(distance == 0) {
                if(r1 != r2) { // 반지름은 다를 때
                    System.out.println("0"); // 두 원이 만나지 않는 경우
                    continue;
                }else {
                    System.out.println("-1"); // 두 원이 일치하는 경우
                    continue;
                }
            }

            if(distance < sumRadius) {
                if(distance + r1 == r2) { // 내접한 경우
                    System.out.println("1");
                }else if (distance + r1 < r2){ // 두 원이 만나지 않는 경우
                    System.out.println("0");
                }else {
                    System.out.println("2"); // 두 교점에서 만나는 경우
                }
            }else if(distance == sumRadius) { // 외접한 경우
                System.out.println("1");
            }else if(distance > sumRadius) { // 두 원이 만나지 않는 경우
                System.out.println("0");
            }

        }
    }

    public static void checkSize() {

        int temp = 0;
        if(x1 < 0) {
            temp = x2;
            x2 = x1;
            x1 = temp;
        }

        if(y1 < 0) {
            temp = y2;
            y2 = y1;
            y1 = temp;
        }

        if(r2 < r1) {
            temp = r2;
            r2 = r1;
            r1 = temp;
        }
    }
}
