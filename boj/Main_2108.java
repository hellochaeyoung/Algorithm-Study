package boj;

import java.io.*;
import java.util.*;

public class Main_2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[4001];
        int[] minusArr = new int[4001];
        int avg = 0;

        for(int i=0;i<N;i++) {
            int n = Integer.parseInt(br.readLine());
            avg += n;
            list.add(n);
            if(n < 0) {
                minusArr[Math.abs(n)]++;
            }else {
                arr[n]++;
            }

        }

        Collections.sort(list);

        int mid = list.get(N/2); // 중앙값

        // 최빈값 구하기
        ArrayList<Integer> indexList = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) {
                if(arr[i] > max) {
                    max = arr[i];
                    indexList.clear();
                    indexList.add(i);
                }else if (arr[i] == max){ // 빈도값이 같으면
                    indexList.add(i);
                }
            }

            if(minusArr[i] != 0) {
                if(minusArr[i] > max) {
                    max = minusArr[i];
                    indexList.clear();
                    indexList.add(i * -1);
                }else if(minusArr[i] == max) {
                    indexList.add(i * -1);
                }
            }

        }

        Collections.sort(indexList);

        int often = 0;
        if(indexList.size() > 1) {
            often = indexList.get(1);
        }else {
            often = indexList.get(0);
        }

        int range = list.get(list.size()-1) - list.get(0);

        System.out.println((int)Math.round((double)avg / N));
        System.out.println(mid);
        System.out.println(often);
        System.out.println(range);

    }
}
