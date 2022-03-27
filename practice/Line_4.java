package practice;

public class Line_4 {

    public int solution(int[] arr, int[] brr) {
        int answer = 0;

        for(int i=0;i<arr.length-1;i++) {
            if(arr[i] != brr[i]) {
                int gap = Math.abs(arr[i] - brr[i]);
                if(arr[i] > arr[i+1]) {
                    arr[i] -= gap;
                    arr[i+1] += gap;
                }else {
                    arr[i] += gap;
                    arr[i+1] -= gap;
                }

                answer++;

            }
        }

        if(arr[arr.length-1] != brr[brr.length - 1]) {
            answer++;
        }

        return answer;

    }
}
