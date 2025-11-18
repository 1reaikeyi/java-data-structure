package 拓扑排序;

public class Edge {
    Ver next;
    int weight;

    public Edge(Ver next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    public Edge(Ver next) {
        this.next = next;
        this.weight = 1;
    }

    public Edge() {
        System.out.println("Edge无参构造");
    }

}
