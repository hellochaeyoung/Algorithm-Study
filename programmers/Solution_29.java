package programmers;

import java.util.ArrayList;
import java.util.List;

class Case {
    String n1, n2, op;
    int cnt;

    public Case(String n1, String n2, String op, int cnt) {
        this.n1 = n1;
        this.n2 = n2;
        this.op = op;
        this.cnt = cnt;
    }
}

public class Solution_29 {

    static String[] name = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] visited = new boolean[name.length];
    static String[] arr = new String[name.length];

    static List<Case> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        
        int n = 2;
        String[] data = {"M~C<2", "C~M>1"};

        System.out.println(solution(n, data));

    }

    public static int solution(int n, String[] data) {

        for(String s : data) {
            String n1 = s.split("")[0];
            String n2 = s.split("")[2];
            String op = s.split("")[3];
            int cnt = Integer.parseInt(s.split("")[4]);

            list.add(new Case(n1, n2, op ,cnt));
        }

        dfs(0);

        return count;
    }

    static void dfs(int depth) {

        if(depth == name.length) {
            if(check()) {
                count++;
            }
            return;
        }

        for(int i=0;i<name.length;i++) {
            if(!visited[i]) {
                visited[i] = true;

                arr[depth] = name[i];
                dfs(depth+1);

                visited[i] = false;
            }
        }
    }

    static boolean check() {

        for(Case c : list) {
            int i=0, j=0;
            for(int t=0;t<arr.length;t++) {
                if(c.n1.equals(arr[t])) {
                    i = t;
                }else if(c.n2.equals(arr[t])) {
                    j = t;
                }
            }

            if(c.op.equals("=")) {
                if(Math.abs(i - j) != c.cnt + 1) {
                    return false;
                }
            }else if(c.op.equals(">")) {
                if(Math.abs(i - j) <= c.cnt + 1) {
                    return false;
                }
            }else {
                if(Math.abs(i - j) >= c.cnt + 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
