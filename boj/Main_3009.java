package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_3009 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();

        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine());

            String x = st.nextToken();
            String y = st.nextToken();

            list.add(x + y);

            xSet.add(x);
            ySet.add(y);


        }

        for (String x : xSet) {
            for(String y : ySet) {
                if(list.contains(x+y)){
                    continue;
                }else {
                    System.out.println(x + " " + y);
                }
            }
        }




    }
}
