package programmers;

import java.util.*;

public class Solution_27 {

    static class Order {
        String order;
        String id;

        public Order(String order, String id) {
            this.order = order;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> map = new HashMap<>();
        List<Order> list = new ArrayList<>();

        for(String st : record) {
            String order = st.split(" ")[0];
            String id = st.split(" ")[1];

            if(!order.equals("Leave")) {
                String nickName = st.split(" ")[2];
                map.put(id, nickName);
            }

            if(!order.equals("Change")) {
                list.add(new Order(order, id));
            }
        }

        answer = new String[list.size()];
        int i=0;
        for(Order o : list) {
            String nickName = map.get(o.id);
            if(o.order.equals("Enter")) {
                answer[i] = nickName + "님이 들어왔습니다.";
            }else if(o.order.equals("Leave")) {
                answer[i] = nickName + "님이 나갔습니다.";
            }

            i++;
        }

        return answer;
    }

}
