package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1544 {

    static String[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N];
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }

        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        int count = 0;

        while(list.size() > 0) {
            String now = list.get(0);
            int len = now.length();

            if(list.size() == 1) { // 남은 문자가 1개라면 비교할 것이 없으므로 그냥 종료
                count++;
                break;
            }

            StringBuilder sb;
            for(int j=0;j<len;j++) {
                //char first = now.charAt(0);
                //String s = now.substring(1) + first; // 첫 글자를 맨 뒤로 옮겨 문자열 생성

                // String은 immutable 속성을 가진다 -> 더하거나 빼거나 계산이 불가능한 변경 불가 값!!
                // 따라서 위와 같이 + 연산을 할 시 이전 값은 쓰레기 값이 되어 가비지 컬렉션이 수거해가고 매번 새로운 값이 생성된다.
                // 즉 연산을 할 때 마다 매번 생성한다는 것! -> 메모리, 속도 측면에서 굉장히 비효율적
                // 따라서 이렇게 문자열 연산이 필요할 땐 StringBuilder나 StringBuffer를 쓰는 것이 좋다
                // 실제로 StringBuilder를 사용하니 메모리 : 16668kb, 시간 : 196ms => 메모리 : 15068kb, 148ms로 확실히 줄어들었다.
                sb = new StringBuilder(now);
                sb = sb.append(sb.charAt(0)).deleteCharAt(0);

                now = sb.toString();
                for(int z=0;z<list.size();z++) {
                    if(now.equals(list.get(z))){ // 리스트에 동일한 문자가 있다면
                        list.remove(z);
                    }
                }

            }

            list.remove(now);
            count++;

        }


        System.out.println(count);
    }
}
