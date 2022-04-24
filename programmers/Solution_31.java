package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_31 {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i=0;i< places.length;i++) {
            String[] p = places[i];

            boolean check = true; //////////
            for (int j = 0; j < places.length && check; j++) {
                for (int z = 0; z < places.length && check; z++) {
                    if (p[j].charAt(z) == 'P') { //////////////////
                        if (!bfs(j, z, p)) {
                            check = false;
                        }
                    }
                }
            }
            answer[i] = check ? 1 : 0;
        }

        return answer;
    }

    static boolean bfs(int x, int y, String[] map) {

        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map.length ||
                        (nx == x && ny == y)) {
                    continue;
                }

                int len = Math.abs(x - nx) + Math.abs(y - ny);

                if(map[nx].charAt(ny) == 'P' && len <= 2) {
                    return false;
                }

                if(map[nx].charAt(ny) == 'O' && len < 2) {
                    queue.add(new int[] {nx, ny});
                }

            }
        }

        return true;
    }
}
