package e归并排序;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        /**
         * 排序前：[5, 4, 3, 2, 1]
         * splitleft: [5, 4, 3]
         * splitleft: [5, 4]
         * splitleft: [5]
         * splitright: [4]
         * merge: [4, 5]
         * splitright: [3]
         * merge: [3, 4, 5]
         * splitright: [2, 1]
         * splitleft: [2]
         * splitright: [1]
         * merge: [1, 2]
         * merge: [1, 2, 3, 4, 5]
         * 排序后：[1, 2, 3, 4, 5]
         */
        int[] array = {5,4,3,2,1};
        System.out.println("排序前：" + Arrays.toString(array));
        sort1(array);
        System.out.println("排序后：" + Arrays.toString(array));

    }
    public static void sort1(int[] array) {
        //递归
        split(array, 0, array.length - 1, new int[array.length]);
    }

    public static void split(int[] a1, int left, int right, int[] a2){
        //copyOfRange(int[] original, int from, int to不包含to)
        if (left < right) {
            // 计算中间位置
            int mid = left + (right - left) / 2;
            // 递归分割左半部分
            int[] printArrayleft = Arrays.copyOfRange(a1, left, (left+right)/2+1);
            System.out.println("splitleft: " + Arrays.toString(printArrayleft));
            split(a1, left, mid, a2);

            int[] printArrayright = Arrays.copyOfRange(a1, (left+right)/2+1, right+1);
            System.out.println("splitright: " + Arrays.toString(printArrayright));
            // 递归分割右半部分
            split(a1, mid + 1, right, a2);

            // 合并左右两部分
            merge(a1, left, mid, mid + 1, right, a2);
        }

    }
    public static void merge(int[] a1, int x, int xend, int y, int yend, int[] a2) {
        // 修正：保存原始左起始索引（避免x被修改后影响后续复制/打印）
        int start = x;
        int k = start;  // 辅助数组的起始位置（与原数组左起始一致）

        // 合并两个有序子数组
        while (x <= xend && y <= yend) {
            if (a1[x] <= a1[y]) {
                a2[k++] = a1[x++];
            } else {
                a2[k++] = a1[y++];
            }
        }

        // 复制左半部分剩余元素
        while (x <= xend) {
            a2[k++] = a1[x++];
        }

        // 复制右半部分剩余元素
        while (y <= yend) {
            a2[k++] = a1[y++];
        }

        // 修正：用原始start作为复制起始索引，完整复制合并结果到原数组
        for (k = start; k <= yend; k++) {
            a1[k] = a2[k];
        }

        int[] mergedArray = Arrays.copyOfRange(a1, start, yend + 1);
        System.out.println("merge: " + Arrays.toString(mergedArray));
    }

}