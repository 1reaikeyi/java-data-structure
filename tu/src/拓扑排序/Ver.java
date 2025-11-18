package 拓扑排序;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Ver {
    String name;
    ArrayList<Edge> edges;
    private boolean visited;
    int count = 0;
    public Ver() {
        System.out.println("Ding无参构造");
        this.edges = new ArrayList<>(); // 自动初始化
    }
    public Ver(String name) {
        this.name = name;
        this.edges = new ArrayList<>(); // 自动初始化
    }
    //深度查询
    public static void printEdges1(Ver a) {
        a.visited = true;
        System.out.println(a.name);
        for (Edge edge : a.edges) {
            if (!edge.next.visited) {
                printEdges1(edge.next);
            }
        }
    }
    //广度查询
    public static void printEdges2(Ver a) {
        ArrayDeque<Ver> queue = new ArrayDeque<>();
        queue.offer(a);
        a.visited = true;
        while (!queue.isEmpty()) {
           Ver top = queue.poll();
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
