package 顺序表;

import java.util.Arrays;

public class Node {
    private int[] data;
    private int size;
    private int capacity;

    public Node() {
        this.data = new int[0];
        this.size = 0;
        this.capacity = 0;
    }
    public Node(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        System.out.println("data初始大小 "+data.length );
        System.out.println("size: " +size);
        System.out.println("capacity空间 "+capacity );
        System.out.println("--进行操作时，从0开始--");
        System.out.println("############################## ");
    }
    /**   0 1 2 3 4 5 6
     *     _ _ _ _ _ _ ()  date
          () _ _ _ _ _ _  size ------->
          () _ _ _ _ _ _  index ------>
          _ _ _ _ _ _ ()  m
     */
    public void addHead(int x) {
        if (size >= capacity) {
            int newCapacity = capacity == 0 ? 1 : capacity *2;
            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
       for(int i = size -1;i >= 0;i--){
           data[i+1] = data[i];
       }
        data[0] = x;
        size++;
    }
    // 时间复杂度 O(1)
//    空间复杂度是O(n)
    public void addTail(int x) {
        if(size == 0){
            addHead(x);
        }
        if (size >= capacity) {
            int newCapacity = capacity == 0 ? 1: capacity *2;
            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
        data[size] = x;
        size++;
    }
    public void add(int index,int x){
        if (index < 0 || index > size) {
            throw new RuntimeException(String.format("索引%d越界,查询范围0到size",index));
        }
        if(size == capacity){
            int newCapacity = capacity == 0 ? 1: capacity *2;
            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
        for(int i = size - 1;i >=index;i--){
            data[i+1] = data[i];
        }
        data[index] = x;
        size++;
    }
    public void remove(int index) {
        if(index < 0 || index >= size){
            throw new RuntimeException(String.format("索引%d越界,查询范围0到size",index));
        }
       for(int i=index;i<size-1;i++){
           data[i] = data[i+1];
       }
       data[size-1] = 0;
       size--;
        if(size <=capacity/2){
            int newcapacity = capacity/2;
            data = Arrays.copyOf(data,newcapacity);
            capacity = newcapacity;
        }
       if(size == 0&&capacity==1){
           clear();
       }

    }
    public int get(int index){
        if(index < 0 || index >= size){
            throw new RuntimeException(String.format("索引%d越界,查询范围0到"+size,index));
        }
        return data[index];
    }
    public int find(int value){
        for(int i=0;i<size;i++){
            if(data[i] == value){
                System.out.println("寻找"+value+"的索引是:"+i);
                return i;
            }
        }
        return -1;
    }
    public void pop(int x){
        int index = find(x);
        if(index == -1){
            throw new RuntimeException(String.format("元素%d不存在",x));
        }else{
            remove(index);
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        data = new int[0];
        size = 0;
        capacity = 0;

    }
    public void printList() {
        System.out.println("size = " + size);
        System.out.println("capacity = " + capacity);
        System.out.println("输出：Arrays.toString(data) = " + Arrays.toString(data));
    }


}
