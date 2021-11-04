package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1544 {

    static String[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }

        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        int count = 0;

        while(list.size() > 0) {
            String now = list.get(0);
            int len = now.length();

            if(list.size() == 1) { // 남은 문자가 1개라면 비교할 것이 없으므로 그냥 종료
                count++;
                break;
            }

            for(int j=0;j<len;j++) {
                char first = now.charAt(0);
                String s = now.substring(1) + first; // 첫 글자를 맨 뒤로 옮겨 문자열 생성
                now = s;
                for(int z=0;z<list.size();z++) {
                    if(now.equals(list.get(z))){ // 리스트에 동일한 문자가 있다면
                        list.remove(z);
                    }
                }

            }

            list.remove(now);
            count++;

        }


        System.out.println(count);
    }
}
