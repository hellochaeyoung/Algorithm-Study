package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line_3 {

    public static void main(String[] args) {

        int num_teams = 2;
        String[] remote = {"design"};
        String[] office = {"building","supervise"};
        String[] employees = {"2 design","1 supervise building design","1 design","2 design"};

        System.out.println(solution(num_teams, remote, office, employees));
    }
    public static List<Integer> solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        //int[] answer = {};

        boolean[] checkTeam = new boolean[num_teams];

        List<String> list = Arrays.asList(office_tasks);
        List<int[]> totalList = new ArrayList<>();

        int i=1;
        for(String s : employees) {
            boolean check = true;
            String[] arr = s.split(" ");
            int team = Integer.parseInt(arr[0]) - 1;

            for(int j=1;j<arr.length;j++) {
                if (list.contains(arr[j])) { // 회사 출근 팀원 체크
                    checkTeam[team] = true;
                    check = false;
                    break;
                }
            }

            if(check) {
                totalList.add(new int[] {i, team});
            }

            i++;
        }

        List<Integer> answer = new ArrayList<>();

        for(int[] arr : totalList) {
            if(!checkTeam[arr[1]]) {
                checkTeam[arr[1]] = true;
                continue;
            }

            answer.add(arr[0]);
        }

        return answer;
    }

}
