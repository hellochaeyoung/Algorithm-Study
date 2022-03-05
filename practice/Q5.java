package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            Collections.sort(list);

            int index = list.size() / 3;

            System.out.println(list.get(index) + " " + list.get(list.size() - (index+1)));
        }
    }
}
