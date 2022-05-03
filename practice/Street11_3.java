package practice;

import java.util.*;

public class Street11_3 {

    static class Photo {
        int index;
        String extension, city, date, time, name;

        public Photo(int index, String extension, String city, String date, String time) {
            this.index = index;
            this.extension = extension;
            this.city = city;
            this.date = date;
            this.time = time;
        }

        public Photo(int index, String name) {
            this.index = index;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        String S = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(solution(S));
    }

    public static String solution(String S) {

        Map<String, List<Photo>> map = new HashMap<>();

        String[] arr = S.split("\n");

        // 1. 도시별로 사진 정보 해시맵에 저장
        for(int i=0;i<arr.length;i++) {
            String[] temp = arr[i].split(", ");
            String extension = temp[0].split("\\.")[1];
            String city = temp[1];
            String date = temp[2].split(" ")[0];
            String time = temp[2].split(" ")[1];

            if(!map.containsKey(city)) {
                map.put(city, new ArrayList<>());
            }
            map.get(city).add(new Photo(i, extension, city, date, time));
        }

        // 2. 도시별 사진 리스트 날짜 순서로 정렬
        for(List<Photo> list : map.values()) {
            list.sort(((o1, o2) -> {
                if (o1.date.equals(o2.date)) {
                    return o1.time.compareTo(o2.time);
                }

                return o1.date.compareTo(o2.date);
            }));
        }

        // 3. 도시별 사진 순서대로 새 이름 설정
        List<Photo> result = new ArrayList<>();
        for(String key : map.keySet()) {
            List<Photo> list = map.get(key);
            int size = list.size();

            String format = "";
            if(size == 100) format = "%03d";
            else if(size >= 10) format = "%02d";
            else format = "%d";

            for(int n=0;n<list.size();n++) {
                Photo p = list.get(n);
                StringBuilder sb = new StringBuilder();
                String name = sb.append(p.city).append(String.format(format, n+1))
                        .append(".").append(p.extension).toString();

                result.add(new Photo(p.index, name));
            }
        }

        // 4. 입력받은 문자열 순서대로 정렬하여 리턴
        result.sort(Comparator.comparingInt(o -> o.index));

        StringBuilder sb = new StringBuilder();
        for(Photo p : result) {
            sb.append(p.name).append("\n");
        }

        return sb.toString().trim();
    }
}
