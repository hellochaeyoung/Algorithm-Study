package practice;

public class Solution1 {

    static int total = 0;
    static int life = 0;
    static int attack = 0;
    static int defense = 0;
    static int time = 0;

    public static void main(String[] args) {
        String answer = "";

        String character = "10 5 2";
        //String[] monsters = {"Knight 3 10 10 3", "Wizard 5 10 15 1", "Beginner 1 1 15 1"};
        String[] monsters = {"Beginner 1 1 15 1"};
        float[] result = new float[monsters.length];

        life = Integer.parseInt(character.split(" ")[0]);
        attack = Integer.parseInt(character.split(" ")[1]);
        defense = Integer.parseInt(character.split(" ")[2]);

        total = life;

        for(int i=0;i<monsters.length;i++) {
            String mName = monsters[i].split(" ")[0];
            int mGive = Integer.parseInt(monsters[i].split(" ")[1]);
            int mLife = Integer.parseInt(monsters[i].split(" ")[2]);
            int mAttack = Integer.parseInt(monsters[i].split(" ")[3]);
            int mDefense = Integer.parseInt(monsters[i].split(" ")[4]);

            System.out.println(mGive +" " +  mLife +" " +  mAttack +" "+ mDefense);

            if(fight(mLife, mAttack, mDefense)) {
                result[i] = (float)mGive / time;
                //System.out.println("######" + mGive / time);
                //System.out.println(mGive);
                //System.out.println(time);
                //System.out.println(result[i]);
            }else {
                result[i] = 0;
                System.out.println(result[i]);
            }

            time = 0; // 시간 초기화
        }

        float max = 0;
        int index = 0;
        for(int i=0;i<result.length;i++) {
            if(result[i] > max) {
                System.out.println(result[i]);
                max = result[i];
                index = i;
            }
        }

        answer = monsters[index].split(" ")[0];

        System.out.println(answer);
        //return answer;
    }

    static boolean fight(int mLife, int mAttack, int mDefense) {

        while(true) {

            time++;

            int playerAttack = attack - mDefense;

            if(playerAttack > 0) {
                mLife -= playerAttack;
                if(mLife <= 0) {
                    return true;
                }
            }

            int monsterAttack = mAttack - defense;

            if(monsterAttack > 0) {
                life -= monsterAttack;
                if(life <= 0) { //player die
                    return false;
                }else {
                    life = total; // 다시 회복
                }
            }


        }

    }
}
