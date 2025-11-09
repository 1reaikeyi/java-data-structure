package c插入排序;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] array = {11,5,4,3,2,1,9,8,7,6,0};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        sort(array);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        for (int i =1;i<len;i++){
            // 记录当前待插入的元素
            int temp = arr[i];
            // 从当前元素的前一个元素开始向前遍历，找到合适的插入位置
            int j = i;
            // 当 j>0 且 arr[j-1] 大于 temp 时，将 arr[j-1] 后移一位，直到找到合适的插入位置
            while (j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
                System.out.println("1--Arrays.toString(arr) = " + Arrays.toString(arr));
            }
            // 将 temp 插入到找到的插入位置
            arr[j] = temp;
            System.out.println("2--Arrays.toString(arr) = " + Arrays.toString(arr));
        }
        System.out.println("sort：Arrays.toString(array) = " + Arrays.toString(arr));

    }

}
