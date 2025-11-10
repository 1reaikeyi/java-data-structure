package e归并排序;

import java.util.Arrays;

public class Iteration {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        System.out.println("排序前：" + Arrays.toString(array));
        sort1(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    // 迭代版归
    public static void sort1(int[] array) {
        // 调用split，传入整个数组的范围（0 ~ 数组长度-1）
        split(array, 0, array.length - 1);
    }
    // 迭代版split（拆分逻辑）
    public static void split(int[] num, int x, int y) {
        int n = num.length; // 数组总长
        for (int step = 1; step < n; step *= 2) {
            // 按当前块大小，遍历所有需要合并的单元
            // left：当前合并单元的左起始索引（从x=0开始，每次跳2*step）
            for (int left = x; left <= y; left += 2 * step) {
                // 左子数组：[left, mid]，长度为step（防越界：mid不能超过总右边界y）
                int mid = Math.min(left + step - 1, y);
                // 右子数组：[mid+1, right]，长度为step（防越界：right不能超过总右边界y）
                int right = Math.min(left + 2 * step - 1, y);

                // 若mid >= right：说明只有左子数组，无右子数组，无需合并
                if (mid >= right) {
                    continue;
                }

                // 打印当前要合并的两个有序子数组（方便观察过程）
                int[] leftArr = Arrays.copyOfRange(num, left, mid + 1);
                int[] rightArr = Arrays.copyOfRange(num, mid + 1, right + 1);
                System.out.printf("合并：左=%s 右=%s → ", Arrays.toString(leftArr), Arrays.toString(rightArr));

                // 调用merge合并两个子数组（复用你已实现的正确merge方法）
                merge(num, left, mid, mid + 1, right,new int[n]);// 辅助数组（复用，避免重复创建）);
            }
        }
    }

    // 合并逻辑（你已实现，无需修改，仅保留注释说明）
    public static void merge(int[] a1, int x, int xend, int y, int yend, int[] a2) {
        int start = x; // 保存原始左起始索引（避免x被修改后影响复制）
        int k = start; // 辅助数组的写入指针

        // 1. 合并两个有序子数组到辅助数组a2
        while (x <= xend && y <= yend) {
            a2[k++] = (a1[x] <= a1[y]) ? a1[x++] : a1[y++];
        }

        // 2. 复制左子数组剩余元素
        while (x <= xend) {
            a2[k++] = a1[x++];
        }

        // 3. 复制右子数组剩余元素
        while (y <= yend) {
            a2[k++] = a1[y++];
        }

        // 4. 将合并结果从a2复制回原数组a1
        for (k = start; k <= yend; k++) {
            a1[k] = a2[k];
        }

        // 打印合并结果
        int[] mergedArr = Arrays.copyOfRange(a1, start, yend + 1);
        System.out.println(Arrays.toString(mergedArr));
    }
}