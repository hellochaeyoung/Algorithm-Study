package boj;

import java.io.*;
import java.util.*;

class Member {

    int number;
    int age;
    String name;


    public Member(int number, int age, String name) {
        this.number = number;
        this.age = age;
        this.name = name;
    }
}
public class Main_10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Member> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(i, age, name));
        }

        Collections.sort(list, (Member m1, Member m2) -> {
            if(m1.age == m2.age) {
                return m1.number - m2.number;
            }else {
                return m1.age - m2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Member m : list) {
            sb.append(m.age + " " + m.name + "\n");
        }

        System.out.println(sb);

    }
}
