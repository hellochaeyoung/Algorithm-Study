package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nex {

    static class Person {
        String name;
        String romaNumber;
        int number;

        public Person(String name, String romaNumber, int number) {
            this.name = name;
            this.romaNumber = romaNumber;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("Uni IX");
        name.add("Uni VIII");

        System.out.println(solution(name).toString());
    }
    public static List<String> solution(List<String> names) {

        List<Person> list = new ArrayList<>();
        for(String st : names) {
            String name = st.split(" ")[0];
            String number = st.split(" ")[1];
            int num = translate(number);
            list.add(new Person(name, number, num));
        }

        list.sort(((o1, o2) -> {
            if(o1.name.equals(o2.name)) {
                return Integer.compare(o1.number, o2.number);
            }

            return o1.name.compareTo(o2.name);
        }));

        List<String> answer = new ArrayList<>();
        for(Person p : list) {
            String total = p.name + " " + p.romaNumber;
            answer.add(total);
        }

        return answer;
    }

    static int translate(String number) {

        int num = 0;
        String[] numbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] tens = {"XX", "XXX", "XL", "L"};

        for(int i=0;i<tens.length;i++) {
            if(number.startsWith(tens[i])) {
                num += (i*10) + 20;
                number = number.substring(tens[i].length());
            }

            if(number.startsWith("X")) {
                num += 10;
                number = number.substring(1);
            }

            for(int j=0;j<numbers.length;j++) {
                if(number.equals(numbers[j])) {
                    num += j + 1;
                    return num;
                }
            }
        }

        return num;
    }
}
