package programmers;

public class Solution_15 {

    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++) {
                for(int z=j+1;z<nums.length;z++) {
                    int sum = nums[i] + nums[j] + nums[z];
                    if(isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    static boolean isPrime(int n) {

        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
