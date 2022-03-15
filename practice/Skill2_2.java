package practice;

import java.util.ArrayList;
import java.util.List;

public class Skill2_2 {

    public String[] solution(int[][] line) {
        String[] answer = {};

        List<long[]> list = new ArrayList<>();

        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for(int i=0;i< line.length-1;i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j=i+1;j< line.length;j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long bottom = a*d - b*c;
                long xt = b*f - e*d;
                long yt = e*c - a*f;

                if(bottom == 0) {
                    continue;
                }

                double x = (double) xt / bottom;
                double y = (double) yt / bottom;

                if(Math.ceil(x) == Math.floor(x) && Math.ceil(y) == Math.floor(y)) {
                    list.add(new long[] {(long) x, (long) y});

                    minX = Math.min(minX, (long) x);
                    maxX = Math.max(maxX, (long) x);
                    minY = Math.min(minY, (long) y);
                    maxY = Math.max(maxY, (long) y);
                }
            }
        }

        boolean[][] map = new boolean[(int)(maxY - minY + 1)][(int)(maxX - minX + 1)];

        for(long[] arr : list) {
            int x = (int) (arr[0] - minX); ///
            int y = (int) (arr[1] - maxY); ///

            map[Math.abs(y)][Math.abs(x)] = true;
        }

        answer = new String[map.length];

        int i = 0;
        for(boolean[] arr : map) {
            StringBuilder sb = new StringBuilder();
            for(boolean b : arr) {
                if(b) {
                    sb.append("*");
                }else {
                    sb.append(".");
                }
            }

            answer[i] = sb.toString();
            i++;
        }

        return answer;
    }
}
