package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_8979 {

    static class Country implements Comparable<Country> {
        int name;
        int gold;
        int silver;
        int bronze;
        boolean isPublic;

        public Country(int name, int gold, int silver, int bronze, boolean isPublic) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.isPublic = false;
        }

        @Override
        public int compareTo(Country c) {
            if(this.gold > c.gold) {
                return 3;
            }else if(this.gold < c.gold){
                return -3;
            }else {
                if(this.silver > c.silver) {
                    return 2;
                }else if(this.silver < c.silver) {
                    return -2;
                }else {
                    if (this.bronze > c.bronze) {
                        return 1;
                    } else if (this.bronze < c.bronze) {
                        return -1;
                    } else {
                        this.isPublic = true;
                        c.isPublic = true;
                        return 0;
                    }
                }
            }
        }

    }

    static ArrayList<Country> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int country = Integer.parseInt(st.nextToken());
        int findCountry = Integer.parseInt(st.nextToken());

        for(int i=0;i<country;i++) {
            st = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            list.add(new Country(name, gold, silver, bronze, false));
        }

        Collections.sort(list, Comparator.reverseOrder());


        int count = 0;
        for(int i=0;i<list.size();i++) {
            if(!list.get(i).isPublic){
                count++;
            }
            if(list.get(i).name == findCountry) {
                if(list.get(i).isPublic) {
                    System.out.println(count+1);
                }else {
                    System.out.println(i+1);
                }
            }
        }
        //System.out.print(c.name + " " + c.gold + " " + c.silver + " " + c.bronze + " ");
        //System.out.println();

    }


}
