package boj;

import java.io.*;
import java.util.*;

public class Main_9934 {

    static class Node {
        int depth;
        int number;

        public Node(int depth, int number) {
            this.depth = depth;
            this.number = number;
        }
    }

    static int size;
    static int[] arr;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int count = (int)(Math.pow(2, K) - 1);
        arr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<count;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int depth = 1; // 깊이 즉 레벨

        size = arr.length-1;

        tree(0,size, depth);

        Collections.sort(list, new Comparator<Node>() { // depth 즉 레벨을 기준으로 정렬
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.depth < o2.depth) {
                    return -1;
                }else if(o1.depth == o2.depth) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });

        int level = list.get(0).depth;
        for(Node n : list) {
            if(n.depth > level) {
                System.out.println();
                level = n.depth;
            }
            System.out.print(n.number + " ");
        }

    }

    static void tree(int start, int end,int depth) {

        int middle = (start + end) / 2;
        int w = end - start;

        if(w == 2) {
            list.add(new Node(depth, arr[middle]));
            list.add(new Node(depth+1, arr[start]));
            list.add(new Node(depth+1, arr[end]));
            return;
        }else {
            list.add(new Node(depth, arr[middle]));
            
            tree(start, middle-1, depth+1);
            tree(middle+1, end, depth+1);
        }

    }

}
