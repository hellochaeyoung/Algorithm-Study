package boj;

import java.io.*;
import java.util.*;

public class Main_4386 {

    static class Edge {
        double start, end, weight;

        public Edge(double start, double end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int N;
    static double[] x;
    static double[] y;
    static double[] parent;
    static PriorityQueue<Edge> queue = new PriorityQueue<>(((o1, o2) -> (int)(o1.weight - o2.weight)));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new double[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }

        x = new double[N];
        y = new double[N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double xi = Double.parseDouble(st.nextToken());
            double yi = Double.parseDouble(st.nextToken());

            x[i] = xi;
            y[i] = yi;
        }

        setWeight();

        double answer = kruskal();

        System.out.println(String.format("%.2f", answer));
    }

    static void setWeight() {

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                double xDistance = Math.pow((x[i] - x[j]), 2);
                double yDistance = Math.pow((y[i] - y[j]), 2);

                double distance = Math.sqrt(xDistance + yDistance);

                queue.add(new Edge(i,j,distance));
            }
        }
    }

    static double kruskal() {

        double weightSum = 0;

        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            if(!isSameParent(edge.start, edge.end)) {
                weightSum += edge.weight;

                union(edge.start, edge.end);
            }
        }

        return weightSum;
    }

    static double find(double x) {
        if(x == parent[(int)x]) {
            return x;
        }else {
            return parent[(int)x] = find(parent[(int)x]);
        }
    }

    static boolean isSameParent(double x, double y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }else {
            return false;
        }
    }

    static void union(double x, double y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) {
                parent[(int)y] = x;
            }else {
                parent[(int)x] = y;
            }
        }
    }
}
