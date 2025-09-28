package array;

public class Main {
    public static void main(String[] args) {
         queueArray<String> queue = new queueArray<>(5);
        queue.offer("元素1");
        queue.offer("元素2");
        queue.offer("元素3");
        queue.offer("元素4");
        queue.printAll();
        System.out.println(queue.peek());
        queue.pull();
        queue.pull();
        queue.printAll();
    }
}
