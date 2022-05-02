package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_43 {

    static char[][] map;

    public static void main(String[] args) {
        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        System.out.println(solution(m,n,board));
    }

    public static int solution(int m, int n, String[] board) {

        int answer = 0;

        map = new char[m][n];

        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            int cnt = checkMap(m,n);
            if(cnt == 0) break; // 더 이상 터질 블록이 없음을 의미
            answer += cnt;
            move(m,n); // 블록 이동
        }


        return answer;
    }

    static int checkMap(int m, int n) {

        int cnt = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m-1;i++) {
            for(int j=0;j<n-1;j++) {
                if(map[i][j] == ' ') continue;
                check(visited, i, j); // 2*2 블록 체크
            }
        }

        // 맵 전체 다 체크 후 터질 블록 빈 공간으로 변경, 미리 체크하고 변경하므로 더 큰 사이즈의 경우도 다 포함됨
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j]){
                    cnt++;
                    map[i][j] = ' ';
                }

            }
        }

        return cnt;
    }

    static void check(boolean[][] visited, int x, int y) {

        char ch = map[x][y];
        for(int i=x;i<x+2;i++) {
            for(int j=y;j<y+2;j++) {
                if(map[i][j] != ch) return; // 하나라도 다른게 있으면 제외
            }
        }

        for(int i=x;i<x+2;i++) {
            for(int j=y;j<y+2;j++) {
                visited[i][j] = true; // 터트릴 블록 표시
            }
        }
    }

    static void move(int m, int n) {

        for(int i=0;i<n;i++) {
            for(int j=m-1;j>=0;j--) {
                if(map[j][i] == ' ') {
                    for(int z=j-1;z>=0;z--) {
                        if(map[z][i] != ' ') {
                            map[j][i] = map[z][i];
                            map[z][i] = ' ';
                            break;
                        }
                    }
                }
            }
        }

    }
}
