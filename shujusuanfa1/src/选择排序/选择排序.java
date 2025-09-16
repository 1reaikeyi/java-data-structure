package 选择排序;

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1,9,8,7,6,0};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        sort(array);
        sort2(array);

    }
    //单向
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
    //双向
    public static void sort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = 0;
            int maxIndex = 0;
            for (int x = 0; x < array.length-i; x++) {
                if (array[x]>array[maxIndex]){
                    maxIndex = x;
                }
                if (array[x]<array[minIndex]){
                    minIndex = x;
                }
            }
            if (maxIndex!= array.length-1-i){
                int temp = array[maxIndex];
                array[maxIndex] = array[array.length-i-1];
                array[array.length-i-1] = temp;
            }
            if (minIndex!= i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }
}
