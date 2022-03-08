package programmers;

public class Solution_4 {

    public int solution(String s) {
        int answer = 0;

        String[] words = {"zero", "one", "two", "three", "four", "five", "six",
                            "seven", "eight", "nine"};

        String regex = "[0-9]+";

        if(s.matches(regex)) {
            return Integer.parseInt(s);
        }

        for(int i=0;i<words.length;i++) {
            if(s.contains(words[i])) {
                s = s.replace(words[i], Integer.toString(i));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
