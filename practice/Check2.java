package practice;

import java.util.Arrays;

public class Check2 {

    public static void main(String[] args) {

        int[] people = {70,80,50};
        int limit = 100;

        Arrays.sort(people);

        int count = 0;
        int i = 0,j = people.length - 1;

        while(i <= j) {
            count++;
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        System.out.println(count);
    }
}
