package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2529 {

    static String[] input;
    static boolean[] check = new boolean[10];
    static int[] numbers;
    static ArrayList<String> list = new ArrayList<>();
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        input = new String[k];
        numbers = new int[k+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++) {
            input[i] = st.nextToken();
        }

        for(int i=0;i<10;i++) {
            dfs(i,0,0);
            check = new boolean[10];
        }

        for(String s : list) {
            System.out.println(s);
        }

    }

    static void dfs(int start, int pre, int depth) {

        if(depth == k+1) {
            String s = "";
            for(int i=0;i<numbers.length;i++) {
                s += numbers[i];
            }
            list.add(s);
            return;
        }

        String comparator = "";
        if(start == k) {
            if(input[start-1].equals(">")){
                comparator = "<";
            }else {
                comparator = ">";
            }
        }else {
            comparator = input[start];
        }


        if(comparator.equals(">")) {
            for(int i=pre+1;i<10;i++) {
                if(!check[i]) {
                    check[i] = true;
                    numbers[depth] = i;
                    dfs(start+1,i,depth+1);
                }
            }
        }else {
            for(int i=0;i<=pre;i++) {
                if(!check[i]) {
                    check[i] = true;
                    numbers[depth] = i;
                    dfs(start+1,i,depth+1);
                }
            }
        }
        return;
    }
}
