package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649 {

    static boolean[] check;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        arr = new int[M];

        dfs(N, M, 0);

    }

    static void dfs(int n, int m, int depth) {

        if(depth == m) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<n;i++) { //n까지 반복, 숫자 종류 다 출력 위해
            if(check[i] == false) { // 이미 확인한 숫자말고(이미 방문한 노드 말고 아직 방문하지 않은 노드!!)
                check[i] = true;
                arr[depth] = i + 1; // depth가 자리수 위치 의미!

                dfs(n,m,depth+1); // 자식 노드 탐색

                check[i] = false; // 다시 false로 해줘야 모든 경우의 순열 탐색 가능
            }
        }

        return;

    }
}
