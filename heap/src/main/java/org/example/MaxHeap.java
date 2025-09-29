package org.example;

public class MaxHeap implements Queue{
    int[] array;
    int size;
    int capacity;
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = capacity;
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        this.capacity = array.length;
        heapify();
    }
    public void heapify() {
//        int child = size++;
//        int parent = (child-1)/2;
        // 从最后一个非叶子节点开始，自底向上进行下沉操作
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }

    }
    /**   size   索引
     *      1    0               7
     *      2    1          5
     *      3    2                     6
     *      4    3      4
     *      5    4            3
     *      6    5                   2
     *      7    6                        1
     *       1
     *      / \
     *     2   3
     *    / \ / \
     *   4  5 6  7
     *   --------
     *       1
     *      / \
     *     2   7
     *    / \ / \
     *   4  5 6  3
     *   --------
     *       1
     *      / \
     *     5   7
     *    / \ / \
     *   4  2 6  3
     *   -----------
     *       7
     *      / \
     *     5   6
     *    / \ / \
     *   4  2 1  3
     */
    private void down(int parent) {
        int left = 2 * parent + 1;
//        int right = 2 * parent + 2;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
           swap(max, parent);
            down(max);
        }
    }
    private void swap(int max, int parent) {
        int temp = array[max];
        array[max] = array[parent];
        array[parent] = temp;
    }

    @Override
    public boolean offer(int value) {
        if(isFull()){
            return false;
        }

        return true;
    }

    @Override
    public int pull() {
        return 0;
    }

    @Override
    public int peek() {
        return  array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
}
