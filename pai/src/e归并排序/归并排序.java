package e归并排序;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1, 9, 8, 7, 6, 0};
        System.out.println("排序前：" + Arrays.toString(array));
        // 调用简化后的归并排序方法
        sort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }


    public static void merge(int[] a1, int i, int iend, int j, int jend, int[] a2) {
        int k = i;
        int start = i;
        while (i <= iend && j <= jend) {
            if (a1[i] <= a1[j]) {
                a2[k++] = a1[i++];
            } else {
                a2[k++] = a1[j++];
            }
        }
        while (i <= iend) {
            a2[k++] = a1[i++];
        }
        while (j <= jend) {
            a2[k++] = a1[j++];
        }
        for (k = start; k <= jend; k++) {
            a1[k] = a2[k];
        }
    }



    public static void split(int[] a1, int left, int right, int[] a2){
        int[] s =Arrays.copyOfRange(a1,left,right+1);
        System.out.println("s = " + Arrays.toString(s));
        if (left >= right) {
           return;
        }
        int mid = (left + right) / 2;
        // 递归排序左半部分
        split(a1, left, mid, a2);
        // 递归排序右半部分
        split(a1, mid + 1, right, a2);
        // 合并左右两部分
        merge(a1, left,mid,mid+1,right, a2);

    }
    public static void sort(int[] a1) {
        int[] a2 = new int[a1.length];
        split(a1, 0, a1.length - 1, a2);
    }
}