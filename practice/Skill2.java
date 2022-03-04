package practice;

public class Skill2 {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,6,7,8,0};

        boolean[] check = new boolean[10];

        for(int i : numbers) {
            check[i] = true;
        }

        int sum = 0;
        for(int i=0;i<check.length;i++) {
            if(!check[i]) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
