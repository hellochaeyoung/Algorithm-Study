package boj;

import java.io.*;
import java.lang.reflect.Array;
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
    //static ArrayList<Node> list = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int count = (int)(Math.pow(2, K) - 1);
        arr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<count;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int middle = count/2; // 최상위 노드의 인덱스
        int depth = 1; // 깊이 즉 레벨

        //list.add(new Node(depth, arr[middle])); // 최상위 노드 추가
        list.add(arr[middle]);
        size = arr.length-1;

        tree(0, middle-1, depth+1); // 왼쪽 서브 트리
        tree(middle+1, arr.length-1,depth+1); // 오른쪽 서브 트리

        for(int i : list) {
            System.out.println(i);
        }
/*
        Collections.sort(list, new Comparator<Node>() { // depth 즉 레벨을 기준으로 정렬
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.depth < o2.depth) {
                    return -1;
                }else {
                    return 1;
                }
            }
        });*/
/*
        int level = list.get(0).depth;
        for(Node n : list) {
            if(n.depth > level) {
                System.out.println();
                level = n.depth;
            }
            System.out.print(n.number + " ");
        }
*/
    }

    static void tree(int start, int end,int depth) {

        if(end == 0) { // 최말단 노드일 경우
            //list.add(new Node(depth, arr[start]));
            list.add(arr[start]);
            return;
        }

        if(start == arr.length-1) { // 최말단 노드일 경우
            //list.add(new Node(depth, arr[end]));
            list.add(arr[end]);
            return;
        }

        int middle = (start + end) / 2;

        if(middle == 1 || middle == size-1) {
            //list.add(new Node(depth, arr[middle]));
            //list.add(new Node(depth+1, arr[start]));
            //list.add(new Node(depth+1, arr[end]));
            list.add(arr[middle]);
            list.add(arr[start]);
            list.add(arr[end]);
            return;
        }else {
            //list.add(new Node(depth, arr[middle]));
            list.add(arr[middle]);
            //depth++;
            tree(0, middle-1, depth+1);
            tree(middle+1, size, depth+1);
        }
    }
}
