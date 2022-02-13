package practice;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {

    public static void main(String[] args) {

        //int[] deposit = {500, 1000, 2000, -1000, -1500, 500};
        int[] deposit = {500, 1000, -300, 200, -400, 100, -100};

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<deposit.length;i++) {
            if(deposit[i] > 0) {
                list.add(deposit[i]);
            }else {
                int last = list.remove(list.size()-1);
                int rest = last + deposit[i];

                while(true) {
                    if(rest > 0) {
                        list.add(rest);
                        break;
                    }else if(rest == 0) {
                        break;
                    }

                    last = list.remove(list.size()-1);
                    rest += last;
                }
            }
        }

        System.out.println(list);
    }
}
