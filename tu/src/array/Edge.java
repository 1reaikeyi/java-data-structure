package array;

public class Edge {
    Ding next;
    int weight;
    public Edge(Ding next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    public Edge(Ding next) {
        this.next = next;
        this.weight = 1;
    }

    public Edge() {
        System.out.println("Edge无参构造");
    }

}
