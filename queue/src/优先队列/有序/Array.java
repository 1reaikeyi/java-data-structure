package 优先队列.有序;

public class Array<T extends Priority> implements Queue<T> {
    private int capacity = 0;
    private int size = 0;
    private Priority[] array;

    public Array(int capacity) {
        this.capacity = capacity;
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(T value) {
        if(isFull()){
            return false;
        }

        // 找到插入位置（按优先级升序排列，数值越小优先级越高）
        int insertIndex = 0;
        while (insertIndex < size && array[insertIndex].priority() <= value.priority()) {
            insertIndex++;
        }

        // 将插入位置后面的元素后移
        for (int i = size; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        // 插入新元素
        array[insertIndex] = value;
        size++;
        return true;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }
        // 有序数组中，最高优先级元素在数组末尾（因为优先级数值越小优先级越高）
        T highestPriority = (T) array[0];

        // 将第一个元素移除，后面的元素前移
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return highestPriority;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }
        // 最高优先级元素在数组开头
        return (T) array[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    // 辅助方法：打印数组内容（用于调试）
    public void printArray() {
        System.out.print("当前队列: ");
        for (int i = 0; i < size; i++) {
            System.out.print("(" + array[i].priority() + ") ");
        }
        System.out.println();
        while (!isEmpty()){
            System.out.println(poll());
        }
    }
}