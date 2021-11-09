package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String paper = br.readLine();
        String word = br.readLine();

        int result = 0;
        while(paper.contains(word)) {
            paper = paper.replace(word, "*");

            result = paper.length() - paper.replace("*", "").length();
        }

        System.out.println(result);
    }
}
