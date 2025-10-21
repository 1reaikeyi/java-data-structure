package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ding {
    String name;
    ArrayList<Edge> edges;
    private boolean visited;

    public Ding() {
        System.out.println("Ding无参构造");
        this.edges = new ArrayList<>(); // 自动初始化
    }
    public Ding(String name) {
        this.name = name;
        this.edges = new ArrayList<>(); // 自动初始化
    }

    public void printEdges1(Ding a) {
        a.visited = true;
        System.out.println(a.name);
        for (Edge edge : a.edges) {
            if (!edge.next.visited) {
                printEdges1(edge.next);
            }
        }
    }
    public void printEdges2(Ding a) {
        ArrayDeque<Ding> queue = new ArrayDeque<>();
        queue.offer(a);
        a.visited = true;
        while (!queue.isEmpty()) {
           Ding top = queue.poll();
           System.out.println(top.name);
           for (Edge edge : top.edges) {
               if (!edge.next.visited) {
                   edge.next.visited = true;
                   queue.offer(edge.next);
               }
           }
        }
    }
}
