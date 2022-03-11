package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Car {
    int number, price;

    public Car(int number, int price) {
        this.number = number;
        this.price = price;
    }
}
public class Solution_13 {

    public static void main(String[] args) throws ParseException {

        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        int[] answer = solution(fees, records);

        for(int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        int[] answer;

        Map<String, String> map = new HashMap<>();
        Map<String, Long> calcMap = new HashMap<>();

        for(String s : records) {
            StringTokenizer st = new StringTokenizer(s);
            String time = st.nextToken();
            String car = st.nextToken();

            if(map.containsKey(car)) {
                String in = map.get(car);
                Long parkingTime = getParkingTime(in, time);

                calcMap.put(car, calcMap.getOrDefault(car, 0L) + parkingTime);
                map.remove(car);
            }else {
                map.put(car, time);
            }
        }

        for(String key : map.keySet()) { // 출차 기록 없는 차들
            String in = map.get(key);
            Long parkingTime = getParkingTime(in, "23:59");

            calcMap.put(key, calcMap.getOrDefault(key, 0L) + parkingTime);
        }

        List<Car> list = new ArrayList<>();
        for(String key : calcMap.keySet()) {
            int price = calc(calcMap.get(key), fees);

            list.add(new Car(Integer.parseInt(key), price));
        }

        list.sort((Comparator.comparingInt(o -> o.number)));

        answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i).price;
        }

        return answer;
    }

    public static Long getParkingTime(String start, String end) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        Date inTime = dateFormat.parse(start);
        Date outTime = dateFormat.parse(end);

        long inDateTime = inTime.getTime();
        long outDateTime = outTime.getTime();


        return (outDateTime - inDateTime) / 60000;

    }

    public static int calc(Long time, int[] fees) {

        if(time <= fees[0]) {
            return fees[1];
        }else {
            int restTime = (int) (time - fees[0]);
            int plusTime = (int) Math.ceil((double) restTime / fees[2]);
            return fees[1] + plusTime * fees[3];
        }
    }
}
