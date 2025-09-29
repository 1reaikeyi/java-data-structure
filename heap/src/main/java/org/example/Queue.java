package org.example;

public interface Queue{
    //向队尾中添加元素
    boolean offer(int value);
    //获取队头元素并删除
    int pull();
    //获取队头元素
    int peek();
    //判断队列是否为空
    boolean isEmpty();
    boolean isFull();

}
