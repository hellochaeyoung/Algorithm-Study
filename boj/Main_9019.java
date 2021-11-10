package boj;

import java.util.*;
import java.io.*;

public class Main_9019 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 깊이의 제한이 없을 땐 bfs로 탐색하는 것이 좋다.
        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            String[] answer = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> q = new LinkedList<>();

            visited[A] = true;
            q.add(A);
            Arrays.fill(answer, "");

            while(!q.isEmpty() && !visited[B]) {
                int now = q.poll();
                int D = (2*now) % 10000;
                int S = (now == 0) ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now/1000;
                int R = (now % 10) * 1000 + now/10;

                if(!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    answer[D] = answer[now] + "D";
                }

                if(!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    answer[S] = answer[now] + "S";
                }

                if(!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    answer[L] = answer[now] + "L";
                }

                if(!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    answer[R] = answer[now] + "R";
                }
            }

            System.out.println(answer[B]);
        }
    }


}
