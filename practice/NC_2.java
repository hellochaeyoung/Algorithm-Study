package practice;

import java.text.SimpleDateFormat;
import java.util.*;

public class NC_2 {

    public static void main(String[] args) {
        String[] birth = {"2000-12-3", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"};

        //String[] birth = {"-2019-12-29-", "1945--10-31", "----------", "20000-123-567"};
        System.out.println(solution(birth));
    }

    public static int solution(String[] birth) {

        int cnt = 0;
        for(String b : birth) {
            if(checkDateFormat(b)) {
                String[] arr = b.split("-");
                if(arr[1].length() < 2) {
                    continue;
                }

                if(arr[2].length() < 2) {
                    continue;
                }

                int year = Integer.parseInt(arr[0]);
                int month = Integer.parseInt(arr[1]);
                int days = Integer.parseInt(arr[2]);

                //System.out.println(year + " " + month + " " + days);

                if(!checkYear(year)) continue;
                if(month == 2) {
                    if(!checkLeapYear(year, days)) continue;
                }else {
                    if(!checkMonthAndDays(month, days)) continue;
                }

                cnt++;
            }
        }

        return cnt;
    }

    static boolean checkDateFormat(String st) {

        String format = "yyyy-MM-dd";

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.setLenient(false);
            dateFormat.parse(st);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean checkYear(int y) {
        return y >= 1900 && y <= 2021;
    }

    static boolean checkLeapYear(int y, int d) {

        if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) { // 윤년
            return d >= 1 && d <= 29;
        }else {
            return d >= 1 && d <= 28;
        }
    }

    static boolean checkMonthAndDays(int m, int d) {

        int[] days31 = {1, 3, 5, 7, 8, 10, 12};
        //int[] days30 = {4, 6, 9, 11};

        if (m >= 1 && m <= 12) {
            if (Arrays.stream(days31).anyMatch(i -> i == m)) {
                return d >= 1 && d <= 31;
            } else {
                return d >= 1 && d <= 30;
            }
        } else {
            return false;
        }

    }

}
