package 最短路径;

import java.util.ArrayList;

public class Ver {
    String name;
    ArrayList<Edge> edges;
    boolean visited;
    // 0: 未访问// 1: 访问中//    // 2: 访问过
    int state;
    // 入度
    int inDegree;
    //距离
    int distance;
    //前驱
    Ver pre;
    //无穷大
    static final int INF = 0x3f3f3f3f;

    int count = 0;
    public Ver() {
        System.out.println("Ding无参构造");
        this.edges = new ArrayList<>(); // 自动初始化
    }
    public Ver(String name) {
        this.name = name;
        this.edges = new ArrayList<>(); // 自动初始化
    }

}
