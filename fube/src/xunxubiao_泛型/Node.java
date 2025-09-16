package xunxubiao_泛型;

public class Node <T>implements usee<T> {
    private T[] data;
    private int size;
    private int capacity;

    public Node() {
        this.data = (T[]) new Object[0];
//        this.data = new T[capacity];
        this.size = 0;
        this.capacity = 0;

    }

    public Node(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
        System.out.println("data初始大小 "+data.length );
        System.out.println("size: " +size);
        System.out.println("capacity空间 "+capacity );
        System.out.println("========================================= ");
    }

    @Override
    public void kai() {
        System.out.println("data大小 "+data.length );
        System.out.println("size: " +size);
        System.out.println("capacity空间 "+capacity );
        System.out.println("========================================= ");
    }

    @Override
    public void toClear() {
         size = 0;
         data = (T[]) new Object[0];
        capacity = 0;
        isEmpty();
        System.out.println("*******************");
    }

    @Override
    public void isEmpty() {
        if(size == 0) {
            System.out.println("顺序表数组为空null");
        } else {
            System.out.println("顺序表数组不为空,size: " +size);
        }
    }

    @Override
    public T get(int index) {
        index = index-1;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        return this.data[index];
    }

    @Override
    public void add(int index, int x) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void set(int index, int x) {

    }

    @Override
    public void findIndex(int x) {

    }
    /**   0 1 2 3 4 5 6
     *    _ _ _ _ _ _    date = m
     _ _ _ _ _ _ ()  date
     () _ _ _ _ _ _  size ------->m = size-1
     () _ _ _ _ _ _  index ------>m = index-1
     _ _ _ _ _ _ ()  m
     */
}
