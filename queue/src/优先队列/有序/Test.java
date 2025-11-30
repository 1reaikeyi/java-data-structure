package 优先队列.有序;



public class Test {
    public static void main(String[] args) {
        Array<KV> array = new Array<>(5);
        array.offer(new KV("元素1-----------",1));
        array.offer(new KV("元素2-----------",4));
        array.offer(new KV("元素3-----------",2));
        array.offer(new KV("元素4-----------",3));
        System.out.println(array.peek());
        array.printArray();

    }
}
