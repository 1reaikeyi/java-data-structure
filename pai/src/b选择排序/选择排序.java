package b选择排序;

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1,9,8,7,6,0};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        sort(array);
        sort2(array);
    }
    public static void sort(int[] array) {
     for (int i = 0; i < array.length; i++) {
         int maxIndex = 0;
         for (int x = 0; x < array.length-i; x++) {
             if (array[x]>array[maxIndex]){
                 maxIndex = x;
             }
         }
       if (maxIndex!= array.length-1-i){
           int temp = array[maxIndex];
           array[maxIndex] = array[array.length-i-1];
           array[array.length-i-1] = temp;
       }

     }
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    public static void sort2(int[] array) {
        int len = array.length;
        // 外层循环：每轮确定1个最小值（已排序区间在开头，长度为i）
        for (int i = 0; i < len - 1; i++) { // 优化：最后1个元素无需比较
            int minIndex = i; // 初始化为未排序区间的起始索引（i）
            // 内层循环：遍历未排序区间（i ~ len-1）
            for (int j = i; j < len; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换最小值与未排序区间的起始元素（避免自身交换）
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        System.out.println("sort2（选最小值放前面）：" + Arrays.toString(array));
    }
}
