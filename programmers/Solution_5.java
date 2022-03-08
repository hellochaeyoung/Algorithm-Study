package programmers;

public class Solution_5 {

    public String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();

        int left = 10, right = 12;
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            }else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            }else {
                if(num == 0) num = 11;
                int gapL = (Math.abs(left - num) / 3) + (Math.abs(left - num) % 3);
                int gapR = (Math.abs(right - num) / 3) + (Math.abs(right - num) % 3);

                if(gapL < gapR) {
                    sb.append("L");
                    left = num;
                }else if(gapR < gapL) {
                    sb.append("R");
                    right = num;
                }else {
                    sb.append(hand.equals("left") ? "L" : "R");
                    if(hand.equals("left")) left = num;
                    else right = num;
                }
            }
        }
        return sb.toString();
    }


}
