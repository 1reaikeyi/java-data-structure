package 希尔排序;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2};
        //             0 1 2 3
        int[] array1 = { 6, 5, 4, 3, 2, 1};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        sort(array1);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                //
                int temp = arr[i];
                int j = i ;
               while( j-gap>=0 && arr[j-gap]>temp){
                   arr[j] = arr[j-gap];
                   j--;
               }
                arr[j] = temp;
                //
            }
            System.out.println("排序后：Arrays.toString(arr) = " + Arrays.toString(arr));
        }
        System.out.println("---------------------------");
        System.out.println("排序后：Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
/**
 假设输入数组为 {9, 8, 7, 6, 5, 4, 3, 2, 1}，数组长度 n = 9。
 第一轮：gap = 4
 子序列 1：{9, 5, 1}，对其进行插入排序后变为 {1, 5, 9}。
 子序列 2：{8, 4}，排序后变为 {4, 8}。
 子序列 3：{7, 3}，排序后变为 {3, 7}。
 子序列 4：{6, 2}，排序后变为 {2, 6}。
 此时数组变为 {1, 4, 3, 2, 5, 8, 7, 6, 9}。
 第二轮：gap = 2
 子序列 1：{1, 3, 5, 7, 9}，排序后仍为 {1, 3, 5, 7, 9}。
 子序列 2：{4, 2, 8, 6}，排序后变为 {2, 4, 6, 8}。
 此时数组变为 {1, 2, 3, 4, 5, 6, 7, 8, 9}。
 第三轮：gap = 1
 此时就是对整个数组进行普通的插入排序，但由于数组已经基本有序，所以排序效率较高，最终数组排序完成，结果为 {1, 2, 3, 4, 5, 6, 7, 8, 9}。
 */

