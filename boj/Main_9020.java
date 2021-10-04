package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_9020 {

    public static class Prime {
        private int n;
        private int m;

        public Prime(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getM() {
            return m;
        }

        public int getN() {
            return n;
        }
    }

    public static boolean[] isNotPrime;
    public static ArrayList<Prime> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());

            isNotPrime = new boolean[n+1];

            checkIsPrime(n);

            findPartition(n);

            printPartition();

            list.clear();
        }
    }

    public static void checkIsPrime(int n) {

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i=2;i<=Math.sqrt(n);i++) {
            for(int j=i*i;j<n+1;j+=i) {
                if(!isNotPrime[j]){
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public static void findPartition(int n) {

        for(int i=0;i<isNotPrime.length;i++) {
            if(!isNotPrime[i]) {
                int rest = n - i;
                if(isNotPrime[rest]){
                    continue;
                }else {
                    isNotPrime[rest] = true;
                    list.add(new Prime(i, rest));
                }
            }
        }
    }

    public static void printPartition() {
        int min = Integer.MAX_VALUE;
        int index = 0;

        for(int i=0;i<list.size();i++) {
            int d = list.get(i).getM() - list.get(i).getN();
            if(d < min) {
                min = d;
                index = i;
            }
        }

        System.out.println(list.get(index).getN() + " " + list.get(index).getM());
    }
}
