package 插入排序;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1,9,8,7,6,0};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        sort(array);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        // 从第二个元素开始，因为第一个元素可认为已经有序
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            // 将大于 key 的元素向后移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 插入 key 到正确的位置
            arr[j + 1] = key;
        }

        System.out.println("sort：Arrays.toString(array) = " + Arrays.toString(arr));



    }
    public static void sort2(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;

        int[] temp = new int[len];
        temp[0] = arr[0];
        int left = 0, right = 0;

        for (int i = 1; i < len; i++) {
            if (arr[i] < temp[left]) {
                // 插入到最左边
                for (int j = left; j > 0; j--) {
                    temp[j] = temp[j - 1];
                }
                temp[0] = arr[i];
                left--;
            } else if (arr[i] > temp[right]) {
                // 插入到最右边
                right++;
                temp[right] = arr[i];
            } else {
                // 插入到中间
                int k = right + 1;
                while (k > 0 && temp[k - 1] > arr[i]) {
                    temp[k] = temp[k - 1];
                    k--;
                }
                temp[k] = arr[i];
                right++;
            }
        }

        // 将临时数组复制回原数组
        for (int i = 0; i < len; i++) {
            arr[i] = temp[i + left];
        }
    }
}
