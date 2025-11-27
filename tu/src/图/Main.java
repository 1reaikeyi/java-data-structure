package 图;

public class Main {
    /**
     *      b
     *      c
     * a {  d   }f
     *      e
     *
     * @param args
     */
    public static void main(String[] args) {
        Ver a = new Ver("a");
        Ver b = new Ver("b");
        Ver c = new Ver("c");
        Ver d = new Ver("d");
        Ver e = new Ver("e");
        Ver f = new Ver("f");
        a.edges.add(new Edge(b, 1));
        a.edges.add(new Edge(c, 1));
        a.edges.add(new Edge(d, 1));
        a.edges.add(new Edge(e, 1));

        b.edges.add(new Edge(f, 1));
        c.edges.add(new Edge(f, 1));
        d.edges.add(new Edge(f, 1));
        e.edges.add(new Edge(f, 1));
//        Ver.printEdges1(a);
        Ver.printEdges2(a);
    }
}
