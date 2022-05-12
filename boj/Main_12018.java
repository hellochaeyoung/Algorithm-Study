package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int mileage = Integer.parseInt(st.nextToken());

        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<p;j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            list.sort(Comparator.reverseOrder());

            if(p >= l) {
                resultList.add(list.get(l-1));
            }else {
                resultList.add(1);
            }
        }

        Collections.sort(resultList);

        int total = 0;
        int cnt = 0;
        for(int num : resultList) {
            total += num;
            if(total > mileage) break;
            cnt++;
        }

        System.out.println(cnt);
    }
}
