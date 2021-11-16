package boj;

import java.util.*;
import java.io.*;

/*
* TreeSet을 쓰면 안되는 이유 : 기본적으로 오름차순 정렬을 하기 때문에 순서가 틀어질 수 있다.
* 이미 오름차순으로 배열을 정렬했기 때문에 입력 순서 그대로 저장하는 LinkedHashSet이 적합하다.
* */
public class Main_15663 {

    static int[] arr;
    static int N;
    static int M;
    static boolean[] visited;
    static int[] answer;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        for(String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int depth) {

        if(depth == M) {
            String str = "";
            for(int i : answer) {
                str += i + " ";
            }
            set.add(str);
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];

                dfs(depth+1);
                visited[i] = false;
            }
        }

        return;
    }
}
