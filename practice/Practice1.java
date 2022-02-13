package practice;

import java.util.Arrays;
import java.util.Collections;

public class Practice1 {

    public static void main(String[] args) {

        int[] t = {3,5,2,9,8};
        int m = 3;

        Arrays.sort(t);

        int sum = 0;
        for(int i=0;i<m;i++) {
            sum += t[i] + 1;
        }

        System.out.println(sum);
    }
}
