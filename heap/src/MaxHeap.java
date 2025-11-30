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
    /**
     * index      0 1 2 3 4 5 6
     * int arr = {1,2,3,4,5,6,7}
     * ************i = 7/2 - 1 = 2
     * 1. parent = 2
     * 2. left = 2 * 2 + 1 = 5
     * 3. right = 2 * 2 + 2 = 6
     * 4. max = 2
     * 5. left = 5 < 7 && arr[5] = 6 > arr[2] = 3
     * 6. max = 5
     * 7. right = 6 < 7 && arr[6] = 7 > arr[5] = 6
     * 8. max = 6
     * 9. max != parent
     * 10. swap(max, parent)
     *  arr[6] = 7,arr[2] = 3
     *  arr[2] = 7,arr[6] = 3
     *             max = 6
     *   arr = {1,2,7,4,5,6,3}
     * 11. down(max)
     * parent = 6
     * left = 2 * 6 + 1 = 13
     * right = 2 * 6 + 2 = 14
     * max = 6
     * left = 13 < 7 && arr[13] = 2 < arr[6] = 3
     * max = 6
     * right = 14 < 7 && arr[14] = 2 < arr[6] = 3
     * max = 6
     * max!= parent
     * down(max)结束 ，跳出循环
     * ************i-- = 1
     * 1. parent = 1
     * 2. left = 2 * 1 + 1 = 3
     * 3. right = 2 * 1 + 2 = 4
     * 4. max = 1
     * 5. left = 3 < 7 && arr[3] = 4 > arr[1] = 2
     * 6. max = 3
     * 7. right = 4 < 7 && arr[4] = 5 > arr[3] = 4
     * 8. max = 4
     * 9. max!= parent
     * 10. swap(max, parent)
     *  arr[4] = 5,arr[1] = 2
     *  arr[1] = 5,arr[4] = 2
     *             max = 4
     *   arr = {1,5,7,4,2,6,3}
     * 11. down(max)
     * parent = 4
     * left = 2 * 4 + 1 = 9
     * right = 2 * 4 + 2 = 10
     * max = 4
     * left = 9 < 7 && arr[9] = 2 < arr[4] = 5
     * max = 4
     * right = 10 < 7 && arr[10] = 6 < arr[4] = 5
     * max = 4
     * max!= parent
     * down(max)结束 ，跳出循环
     * ************i-- = 0
     * 1. parent = 0
     * 2. left = 2 * 0 + 1 = 1
     * 3. right = 2 * 0 + 2 = 2
     * 4. max = 0
     * 5. left = 1 < 7 && arr[1] = 5 > arr[0] = 1
     * 6. max = 1
     * 7. right = 2 < 7 && arr[2] = 7 > arr[1] = 5
     * 8. max = 2
     * 9. max!= parent
     * 10. swap(max, parent)
     *  arr[2] = 7,arr[0] = 1
     *  arr[0] = 7,arr[2] = 1
     *             max = 2
     *   arr = {7,5,1,4,2,6,3}
     *   11. down(max)
     *   parent = 2
     *   left = 2 * 2 + 1 = 5
     *   right = 2 * 2 + 2 = 6
     *   max = 2
     *   left = 5 < 7 && arr[5] = 2 < arr[2] = 1
     *   max = 2
     *   right = 6 < 7 && arr[6] = 6 < arr[2] = 1
     *   max = 2
     *   max!= parent
     *   down(max)结束 ，跳出循环
     *   ************i-- = -1<0
     *   结束循环
     *   arr = {7,5,1,4,2,6,3}
     */

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
