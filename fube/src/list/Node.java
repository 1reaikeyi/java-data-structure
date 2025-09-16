package list;

import java.util.Arrays;


public class Node implements usee {
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
        this.size = 0;
        this.capacity = capacity;

        System.out.println("data初始大小 "+data.length );
        System.out.println("size: " +size);
        System.out.println("capacity空间 "+capacity );
        System.out.println("========================================= ");
    }
//    时间复杂度: O(1) - 仅执行简单的变量初始化和数组创建操作
//    空间复杂度: O(1) - 创建固定大小的数组，空间消耗与输入规模无关


    @Override
    public void kai() {
        System.out.println("data大小 "+data.length );
        System.out.println("size: " +size);
        System.out.println("capacity空间 "+capacity );
        if (size == 0 ) {
            System.out.println("data数组是null");
        } else {
            System.out.println("data数组 "+Arrays.toString(data));
        }
        System.out.println("========================================= ");

    }
//    时间复杂度: O(1) - 仅执行简单的变量初始化和数组创建操作
//    空间复杂度: O(1) - 创建固定大小的数组，空间消耗与输入规模无关

    @Override
    public void toClear() {
        data = new int[0];
        size = 0;
        capacity = 0;
        System.out.println("data数组是null");
        System.out.println("*******************");

    }
//    时间复杂度: O(1) - 仅执行简单的条件判断
//    空间复杂度: O(1) - 不使用额外的空间，空间消耗与输入规模无关
    @Override
    public void isEmpty() {
        if (size == 0) {
            System.out.println("顺序表数组为空");
        } else {
            System.out.println("顺序表数组不为空,size: " +size);
        }
    }
//    时间复杂度: O(1) - 仅执行简单的条件判断
//    空间复杂度: O(1) - 不使用额外的空间，空间消耗与输入规模无关
    /**   0 1 2 3 4 5 6
     *    _ _ _ _ _ _    date = m
          _ _ _ _ _ _ ()  date
         () _ _ _ _ _ _  size ------->m = size-1
         () _ _ _ _ _ _  index ------>m = index-1
          _ _ _ _ _ _ ()  m
    */

    @Override
    public int get(int index) {
        index = index - 1;
        if(index<0 || index>size){
            throw new RuntimeException(String.format("%d不合法",index));
        }
        return data[index];
    }
//    时间复杂度: O(n) - 遍历数组，最坏情况下需要遍历所有元素
//    空间复杂度: O(1) - 不使用额外的空间，空间消耗与输入规模无关
    @Override
    public void findIndex(int x) {
        for (int i = 0; i < size; i++) {
            if (data[i] == x) {
                System.out.println("找到元素 " + x + " 在索引 " + i +" ,位置:" + (i+1) );
                return;
            }
        }
        System.out.println("未找到元素 " + x+",不存在:" +x);
    }
//    时间复杂度: O(n) - 遍历数组，最坏情况下需要遍历所有元素
//    空间复杂度: O(1) - 不使用额外的空间，空间消耗与输入规模无关
    @Override
    public void add(int index, int x) {
        index = index - 1;
        if(index<0 || index>size){
            throw new RuntimeException(String.format("%d不合法",index));
        }
          if(size>=capacity){
              int newcapacity = capacity == 0 ? 1 :capacity * 2;
              data = Arrays.copyOf(data,newcapacity);
              capacity = newcapacity;
          }
          for(int i = size - 1; i >= index; i--) {
              data[i + 1] = data[i];
          }
          data[index] = x;
          size++;
    }
//    时间复杂度: O(n) - 遍历数组，最坏情况下需要遍历所有元素
//    空间复杂度: O(1) - 不使用额外的空间，空间消耗与输入规模无关
    @Override
    public void remove(int index) {
        index = index - 1;
        if(index<0 || index>size){
            throw new RuntimeException(String.format("%d不合法",index));
        }
        for(int i = index;i<size-1;i++){
            data[i] = data[i+1];
        }
        data[size-1] = 0;
        size--;
    }
//    时间复杂度: O(1) - 仅执行简单的条件判断和数组元素赋值操作
//    空间复杂度: O(1) - 不使用额外的空间，空间消耗与输入规模无关
    @Override
    public void set(int index, int x) {
        index = index - 1;
        if(index<0 || index>size){
            throw new RuntimeException(String.format("%d不合法",index));
        }
        data[index] = x;
    }
//    时间复杂度: O(1) - 通过数组索引直接修改元素
//    空间复杂度: O(1) - 不使用额外空间


}