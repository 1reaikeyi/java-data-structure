package array;

import java.util.Arrays;

public class queueArray<E> implements Queue<E>{
    private int size = 0;
    private int capacity = 0;
    private E[] data;
    private int head = 0;
    private int tail = 0;
    public queueArray(){
        this.data = null;
    }
    public queueArray(int capacity){
        this.data = (E[]) new Object[capacity+1];
        this.capacity = capacity;
    }
    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    @Override
    public E pull() {
        if(isEmpty()){
            return null;
        }
        E value = data[head];
        head = (head + 1) % capacity;
        size--;
        return value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        E value = data[head];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
    public void printAll(){
        System.out.println("size = " + size);
        System.out.println("haed = " + head);
        System.out.println("tail = " + tail);
//        System.out.println("Arrays.toString(data) = " + Arrays.toString(data));
        for(int i = head; i != tail; i = (i + 1) % capacity){
            System.out.print(data[i] + "\t");
        }

        System.out.println("####################");

    }
}
