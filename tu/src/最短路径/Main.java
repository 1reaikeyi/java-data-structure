package 最短路径;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Ver v1 = new Ver("元素1");
        Ver v2 = new Ver("元素2");
        Ver v3 = new Ver("元素3");
        Ver v4 = new Ver("元素4");
        Ver v5 = new Ver("元素5");
        Ver v6 = new Ver("元素6");
        Ver v7 = new Ver("元素7");
        v1.edges.add(new Edge(v3, 1));
        v2.edges.add(new Edge(v3, 1));
        v3.edges.add(new Edge(v4, 1));
        v3.edges.add(new Edge(v5, 1));
        v4.edges.add(new Edge(v7, 1));
        v5.edges.add(new Edge(v7, 1));
        v6.edges.add(new Edge(v7, 1));
        // 将所有顶点添加到list中
        ArrayList<Ver> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        list.add(v7);
        /**
         v1      v2      v6
         \     /        |
         \   /         |
         v3           |
         /   \         |
         /     \        |
         v4       v5      |
         \     /        |
         \   /         |
         v7 ←---------+
         */
// 统计每个顶点的入度（有多少边指向它）
        for (Ver v : list) {
            for (Edge e : v.edges) {
                e.next.count++;  // 增加目标顶点的入度计数
            }
        }

// 输出每个顶点的入度（依赖数量）
        for (Ver v : list) {
            System.out.println(v.name + "的依赖数量：" + v.count);
        }
//        Ver.printEdges1(v1);

        System.out.println("广度拓扑搜索：");
        //拓扑
        LinkedList<Ver> queue = new LinkedList<>();
        for (Ver v : list) {
            if (v.count == 0) {
                queue.add(v);
            }
        }
        while (!queue.isEmpty()) {
            Ver v = queue.poll();
            System.out.println(v.name);
            for (Edge e : v.edges) {
                e.next.count--;
                if (e.next.count == 0) {
                    queue.add(e.next);
                }
            }
        }
    }

}
