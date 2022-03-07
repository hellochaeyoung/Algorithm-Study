package practice;

import java.util.Arrays;

public class Check3 {

    public static void main(String[] args) {

        int[] citations = {3,0,6,1,5};

        Arrays.sort(citations);

        for(int i=0;i<citations.length;i++) {
            int h = citations.length - i;

            if(citations[i] >= h) {
                System.out.println(h);
            }
            break;
        }

    }
}
