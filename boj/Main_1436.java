package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        int n = 1;
        int i = 1000;
        while(n <= 10000) {



            if(i % 100 == 66) {
                for(int j=0;j<=99;j++) {
                    list.add(i + "6" + j);
                    n++;
                }
            }
            if(i % 10 == 6) {
                for(int j=0;j<=9;j++) {
                    list.add(i + "66" + j);
                    n++;
                }
            }else {
                list.add(i + "666");
                n++;
            }
            i++;
        }

        int z = 1;
        for(String s : list) {
            System.out.println(s + " " + z);
            z++;
        }

        System.out.println(list.get(N-1));

    }
}
