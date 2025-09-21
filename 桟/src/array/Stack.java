package array;

public interface Stack<E>{
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract boolean push(E value);
    E pop();
    E peek();

}
