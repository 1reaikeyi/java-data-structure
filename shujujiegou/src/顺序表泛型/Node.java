package 顺序表泛型;

import java.util.Arrays;

public class Node<T> {
    private T[] elements;
    private int n;
    private int capacity;

    public Node() {
        this.elements = (T[]) new Object[0];
       this.n = 0;
        this.capacity = 0;
    }

    public Node(int capacity) {
        this.capacity = capacity;
        this.n = 0;
        this.elements = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public void clear() {
        this.n = 0;
        this.capacity = 0;
        this.elements = (T[]) new Object[0];
    }

   public void printList() {
       System.out.println("n长度 = " + n);
       System.out.println("Arrays.toString(elements) = " + Arrays.toString(elements));
   }

    public T find(int i) {
        if (i < 0 || i >= n) {
            throw new RuntimeException(String.format("索引%d越界,查询范围0到"+n,i));
        }
        return this.elements[i];
    }
    public int get(T value) {
        for (int i=0;i<n;i++){
            if (elements[i].equals(value)) {
                System.out.println(value+"的索引值是:"+i);
                return i;
            }
        }
        return -1;
    }
    public void insert(int i, T x) {
        if (i < 0|| i >n) {
            throw new RuntimeException(String.format("索引%d越界,查询范围0到"+n,i));
        }
        // 先判断是否需要扩容
        if (n >= capacity) {
            int newCapacity = capacity == 0 ? 1 : capacity * 2;
            elements = Arrays.copyOf(elements, newCapacity);
            capacity = newCapacity;
        }
        for (int j = n - 1; j >= i; j--) {
            elements[j + 1] = elements[j];
        }
        elements[i] = x;
        n++;
    }
    public void delete(int i) {
        if (i < 0 || i >= n) {
            throw new RuntimeException(String.format("索引%d越界,查询范围0到"+n,i));
        }
       for (int j = i; j < n - 1; j++) {
           elements[j] = elements[j + 1];
       }
       elements[n-1] = null;
       n--;
       if(n<=capacity/2){
           int newcapacity = capacity/2;
           elements = Arrays.copyOf(elements,newcapacity);
           capacity = newcapacity;
       }

    }
}