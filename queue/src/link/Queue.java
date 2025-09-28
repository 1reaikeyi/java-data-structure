package link;

public interface Queue <T>{
    //向队尾中添加元素
    boolean offer(T value);
    //获取队头元素并删除
    T pull();
    //获取队头元素
    T peek();
    //判断队列是否为空
    boolean isEmpty();
    boolean isFull();

}
