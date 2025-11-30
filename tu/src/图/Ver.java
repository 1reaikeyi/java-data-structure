package 图;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Ver {
    public String name;
    ArrayList<Edge> edges;
    private boolean visited;

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
        for (int i = 0; i < a.edges.size(); i++){
            Edge ver = a.edges.get(i);
            if (!ver.next.visited) {
                printEdges1(ver.next);
            }
        }
//        for (Edge ver : a.edges) {
//            if (!ver.next.visited) {
//                printEdges1(ver.next);
//            }
//        }
    }
    //广度查询
    public static void printEdges2(Ver a) {
        ArrayDeque<Ver> queue = new ArrayDeque<>();
        queue.offer(a);
        a.visited = true;
        while (!queue.isEmpty()) {
           Ver top = queue.peek();
           queue.pop();
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
