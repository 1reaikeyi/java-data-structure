package 冒泡排序;

import java.util.Arrays;

public class 冒泡排序 {
    public static class BidirectionalBubbleSort {
        public static void main(String[] args) {
            int[] array = {11, 0, 22, 99, 33, 88, 44, 55, 66, 77};
            int[] sorted = sort2(array);
            System.out.println("Arrays.toString(sorted) = " + Arrays.toString(sorted));
        }
        public static int[] sort1(int[] array) {
            long startTime = System.currentTimeMillis();
            //单向
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length-1-i; j++) {
                    if(array[j]>array[j+1]){
                        int temp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = temp;
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            long timeDiff = endTime - startTime;
            System.out.println("timeDiff = " + timeDiff);
            return array;
        }
        public static int[] sort2(int[] arr) {
            long startTime = System.currentTimeMillis();
            //双向
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                // 从左到右比较并交换
                for (int i = left; i < right; i++) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
                right--;

                // 从右到左比较并交换
                for (int i = right; i > left; i--) {
                    if (arr[i] < arr[i - 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i - 1];
                        arr[i - 1] = temp;
                    }
                }
                left++;

            }
            long endTime = System.currentTimeMillis();
            long timeDiff = endTime - startTime;
            System.out.println("timeDiff = " + timeDiff);
            return arr;
        }

    }
}
