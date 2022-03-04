package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skill1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int n = Integer.parseInt(br.readLine());

        char[] arr = s.toCharArray();

        for(int i=0;i<arr.length;i++) {
            if(arr[i] != ' '){
                if(Character.isUpperCase(arr[i])) {
                    arr[i] += n;
                    if(arr[i] > 'Z') {
                        arr[i] = (char)('A' + (arr[i] - 'Z'));
                    }
                }else {
                    arr[i] += n;
                    if(arr[i] > 'z') {
                        arr[i] = (char)('a' + (arr[i] - 'z'));
                    }
                }
            }
        }

        System.out.println(String.valueOf(arr));
    }

}
