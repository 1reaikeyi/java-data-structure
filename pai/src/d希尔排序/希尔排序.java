package d希尔排序;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] array = {5, 4, 1,3, 2};
        int[] array1 = { 6, 5, 4, 3, 2, 1};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        sort(array);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        /**
         */
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j - gap >= 0 && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        }
        System.out.println("---------------------------");
        System.out.println("排序后：Arrays.toString(arr) = " + Arrays.toString(arr));
    }


    public static void twoWayShellSort(int[] arr) {
        int n = arr.length;
        // 外层 gap 循环（增量递减）
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\n=== gap=" + gap + " 分组排序 ===");

            // 遍历每个组（groupStart：每组的起始索引，0~gap-1）
            for (int groupStart = 0; groupStart < gap; groupStart++) {
                // 1. 计算当前组的元素个数和首尾索引（组内元素：groupStart, groupStart+gap, ...）
                int groupSize = 0;
                for (int j = groupStart; j < n; j += gap) groupSize++;
                if (groupSize <= 1) continue; // 组内只有1个元素，无需排序

                // 组内首尾元素的原数组索引
                int firstIdx = groupStart;
                int lastIdx = groupStart + (groupSize - 1) * gap;

                // 2. 先让组内首尾元素有序（初始化有序区间）
                if (arr[firstIdx] > arr[lastIdx]) {
                    int temp = arr[firstIdx];
                    arr[firstIdx] = arr[lastIdx];
                    arr[lastIdx] = temp;
                }

                // 3. 双向收敛核心：左右指针向中间遍历
                int left = 1; // 组内左指针（从第2个元素开始）
                int right = groupSize - 2; // 组内右指针（从倒数第2个元素开始）
                int mid = groupSize / 2; // 收敛终点

                while (left <= mid && right >= mid) {
                    // ---------------------- 处理左指针元素（插入左侧有序区间）----------------------
                    int leftOrigIdx = groupStart + left * gap; // 左指针元素的原数组索引
                    int leftVal = arr[leftOrigIdx];
                    int jLeft = left - 1; // 左侧有序区间的最后位置（组内索引）
                    // 组内向左查找插入位置（原数组索引 = groupStart + jLeft*gap）
                    while (jLeft >= 0 && arr[groupStart + jLeft * gap] > leftVal) {
                        // 元素后移 gap 位
                        arr[groupStart + (jLeft + 1) * gap] = arr[groupStart + jLeft * gap];
                        jLeft--;
                    }
                    // 插入左指针元素
                    arr[groupStart + (jLeft + 1) * gap] = leftVal;

                    // ---------------------- 处理右指针元素（插入右侧有序区间）----------------------
                    int rightOrigIdx = groupStart + right * gap; // 右指针元素的原数组索引
                    int rightVal = arr[rightOrigIdx];
                    int jRight = right + 1; // 右侧有序区间的第一个位置（组内索引）
                    // 组内向右查找插入位置（原数组索引 = groupStart + jRight*gap）
                    while (jRight <= groupSize - 1 && arr[groupStart + jRight * gap] < rightVal) {
                        // 元素前移 gap 位
                        arr[groupStart + (jRight - 1) * gap] = arr[groupStart + jRight * gap];
                        jRight++;
                    }
                    // 插入右指针元素
                    arr[groupStart + (jRight - 1) * gap] = rightVal;

                    // 指针向中间收敛
                    left++;
                    right--;
                }

                System.out.println("  第" + (groupStart + 1) + "组排序后：" + Arrays.toString(arr));
            }
        }
    }
}


