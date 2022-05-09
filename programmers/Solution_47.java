package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution_47 {

    public static void main(String[] args) {
        int[] number = {3,30,34,5,9};

        System.out.println(solution(number));
    }

    public static String solution(int[] numbers) {

        String[] arr = new String[numbers.length];
        for(int i=0;i<arr.length;i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1 + o2));

        //Arrays.sort(arr, (o1, o2) -> -Integer.compare(Integer.parseInt(o1 + o2), Integer.parseInt(o2 + o1)));

        if(arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

}
