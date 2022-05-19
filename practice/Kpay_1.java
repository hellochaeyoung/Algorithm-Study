package practice;

import java.util.*;

public class Kpay_1 {

    public static void main(String[] args) {
        int region = 1;
        int num = 7;
        //int[][] info = {{1, 0, 2, 1}, {2, 6, 5, 2}, {3, 10, 2, 4}, {1, 1, 5, 6}, {2, 7, 10, 2}, {3, 8, 6, 3}};

        //int[][] info = {{3, 8, 6, 2}, {1, 12, 5, 2}, {3, 2, 9, 5}, {3, 6, 10, 1}, {1, 10, 5, 3}};
        int[][] info = {{1, 0, 2, 1}, {2, 6, 5, 2}, {3, 10, 2, 4}, {1, 1, 5, 6}, {2, 7, 10, 2}, {3, 8, 6, 3}};

        System.out.println(Arrays.toString(solution(region, num, info)));
    }

    public static int[] solution(int region, int num, int[][] info) {

        List<int[]> regionList = new ArrayList<>();
        List<int[]> otherList = new ArrayList<>();

        for(int i=0;i< info.length;i++) {
            int[] arr = info[i];
            int sum = (arr[1] + 1) * 2 + (arr[2] + 2) + (arr[3] + 1) * 5;

            if(arr[0] != region) {
                otherList.add(new int[] {i+1, arr[0], sum, -1}); // 신청 순서, 지역, 가점, 순위
            }else {
                regionList.add(new int[] {i+1, arr[0], sum, -1}); // 신청 순서, 지역, 가점, 순위
            }

        }

        otherList.sort((o1, o2) -> {
            if (o2[2] == o1[2]) {
                return o1[0] - o2[0];
            }
            return o2[2] - o1[2];
        });

        regionList.sort((o1, o2) -> {
            if (o1[2] == o2[2]) {
                return o1[0] - o2[0];
            }
            return o2[2] - o1[2];
        });



        int rank = 0;
        num = Math.min(num, info.length);
        int size = regionList.size();
        int times = Math.min(size, num);

        for(int i=0;i<times;i++) {
            regionList.get(i)[3] = ++rank;
        }

        if(rank != num) {
            int rest = num - size;
            for(int i=0;i<rest;i++) {
                otherList.get(i)[3] = ++rank;
            }
        }


        otherList.addAll(regionList);
        otherList.sort(Comparator.comparingInt(o -> o[0]));

        for(int[] arr : otherList) {
            System.out.println(Arrays.toString(arr));
        }

        int[] answer = new int[info.length];
        for(int i=0;i<info.length;i++) {
            answer[i] = otherList.get(i)[3];
        }

        return answer;

    }
}
