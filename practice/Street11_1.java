package practice;

public class Street11_1 {

    public static void main(String[] args) {

        System.out.println(solution(78, 195378678));
    }

    public static int solution(int A, int B) {

        String a = String.valueOf(A);
        String b = String.valueOf(B);

        if(b.contains(a)) {
            return b.indexOf(a);
        }else {
            return -1;
        }
    }
}
