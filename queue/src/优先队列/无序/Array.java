package 优先队列.无序;

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
        array[size++] = value;
        return true;
    }
    private int min(){
        int min = 0;
        for(int i = 1; i < size; i++){
            if (array[i].priority() < array[min].priority()){
                min = i;
            }
        }
        return min;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }
        int minIndex = min();
        T minValue = (T) array[minIndex];
        for(int i = minIndex; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array[--size] = null; // 清除最后一个元素
        return minValue;

    }

    @Override
    public T peek() {
        return (T) array[min()];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
    public void printArray() {
        System.out.print("当前队列: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i].priority() + "\t");

        }
        System.out.println();
        while (!isEmpty()){
            System.out.println(poll());
        }
    }
}
