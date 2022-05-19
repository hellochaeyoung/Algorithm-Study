package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kpay_2 {

    static int N,M;
    static int[][] map;
    static int startRow = 0, startCol = 0;

    public static void main(String[] args) {
        int n = 7, m=8;

        int[][] rectangle = {{2,2}, {1,4}, {3,2}};

        System.out.println(Arrays.deepToString(solution(n, m, rectangle)));
    }

    public static int[][] solution(int n, int m, int[][] rectangle) {

        N = n;
        M = m;
        map = new int[n][m];

        Arrays.sort(rectangle, Comparator.comparingInt(o -> o[0]));

        List<int[]> resultList = new ArrayList<>();

        for(int[] arr : rectangle) {
            for(int i=0;i<arr[1];i++) {
                //System.out.println(arr[0] + " " + arr[1]);
                int[] result = find(arr[0]);
                if(result[0] == -1) {
                    return listToArray(resultList);
                }
                resultList.add(result);
            }
        }

        return listToArray(resultList);
    }

    static int[][] listToArray(List<int[]> list) {

        int[][] answer = new int[list.size()][3];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static int[] find(int l) {

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(map[j][i] == 0) {
                    if(check(j,i,l)) {
                        //System.out.println("########## " + j + " " + i + " " + l);
                        for(int a=j;a<j+l;a++) {
                            for(int b=i;b<i+l;b++) {
                                //System.out.println(a + " " + b);
                                map[a][b] = 1;
                            }
                        }
                        return new int[]{j,i,l};
                    }
                }
            }
        }

        return new int[] {-1,-1,-1};
    }

    static boolean check(int x, int y, int len) {

        for(int i=x;i<x+len;i++) {
            for(int j=y;j<y+len;j++) {
                if(i >= N || j >= M || map[i][j] != 0) return false;
            }
        }

        return true;
    }
}
