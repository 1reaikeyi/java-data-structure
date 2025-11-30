package 优先队列.有序;

public class KV implements Priority {
    public String k;
    public int v;
    public KV(){

    }
    public KV(String t, int i) {
        this.k = t;
        this.v = i;
    }

    @Override
    public int priority() {
        return v;
    }

    @Override
    public String toString() {
        return "{" +
                "k='" + k + '\'' +
                ", v=" + v +
                '}';
    }
}
