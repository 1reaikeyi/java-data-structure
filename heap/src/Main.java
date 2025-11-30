import java.util.Arrays;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
     MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println("Arrays.toString(maxHeap.array) = " + Arrays.toString(maxHeap.array));
        MaxHeap heap = new MaxHeap(10);
//        heap.offer(1);
//        heap.offer(2);
//        heap.offer(3);
//        heap.offer(4);
//        heap.offer(10);
        System.out.println("heap.peek() = " + heap.peek());
        heap.pull();
        heap.printAll();
    }
}