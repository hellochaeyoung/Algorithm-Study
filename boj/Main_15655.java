package boj;

import java.io.*;
import java.util.*;

public class Main_15655 {

    static int[] arr;
    static boolean[] check;
    static int[] number;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N];
        number = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);

        System.out.println(sb);

    }

    static void dfs(int start, int depth) {

        if(depth == M) {
            for(int n : number) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++) {
            number[depth] = arr[i];

            // 전위 연산자를 써야하는 이유
            // 후위 연산자는 그 다음 줄의 코드부터 적용됨
            // 재귀 호출 했기 때문에 다음으로 넘어 간 것이 아니기 때문에 원하는 것처럼
            // 증가된 값의 인자로 함수를 재귀 호출하지 않음
            // 따라서 코드에 바로 적용되는 전위 연산자를 사용해 문제 해결!
            dfs(++start, depth+1);
        }
        return;
    }
}
