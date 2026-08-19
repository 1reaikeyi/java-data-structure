public class MaxHeap implements Queue{
    int[] array;
    int size ;
    int capacity;
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        this.capacity = array.length;
        maxHeap();
    }
    /**   size   索引
     *      1    0               7
     *      2    1          5
     *      3    2                     6
     *      4    3      4
     *      5    4            2
     *      6    5                   1
     *      7    6                        3
     */
    public void maxHeap() {

        // 从最后一个非叶子节点开始，自底向上进行下沉操作
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
//        int right = left + 1;
        int max = parent;
        // 找到左右子节点中较大的节点
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        // 如果较大的节点不是父节点，则交换父节点和较大节点的
        if (max != parent) {
           swap(max, parent);
           // 递归地对较大节点进行下沉操作
            down(max);
        }
    }
    private void up(int value) {
        int child = size;
        while (child > 0) {
            int parent = (child-1) / 2;
            if (value > array[parent]) {
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = value;
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
        up(value);
        size++;
        return true;
    }


    @Override
    public int pull() {
        if(isEmpty()){
            return -1;
        }
        int top = array[0];
        swap(0, top - 1);
        size--;
        down(0);
        return top;
    }
    public int del(int index) {
        if(isEmpty()){
            return -1;
        }
        int del = array[index];
        swap(index,size-1);
        size--;
        down(index);
        return del;
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
    public void printAll() {
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
