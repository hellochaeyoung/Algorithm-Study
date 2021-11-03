package boj;

import java.io.*;


public class Main_13699 {

    // long형 쓰는게 굉장히 중요!!!
    // 처음에 int형으로 하니까 자릿수 부족으로 값이 제대로 계산되지 않았다.
    // 결과 숫자 범위를 잘 체크할 것.
    static long[] arr = new long[36];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 1;

        System.out.println(t(n));
    }

    static long t(int n) {

        if(n == 0){
            return arr[0];
        }else if(n == 1) {
            return arr[1];
        }

        long result = 0;

        for(int i=2;i<=n;i++) {
            int index = i;
            for(int j=0;j<i;j++) {
                result += arr[j]*arr[--index];
            }
            arr[i] = result;
            result = 0;
        }

        return arr[n];
    }
}
