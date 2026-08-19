package a冒泡排序;

import java.util.Arrays;

public class 冒泡排序 {
    /**
     * groupBubbleSort - 分组冒泡排序
     * 时间复杂度：O(n²)
     * 最好情况：O(n).txt - 当数组已经有序时
     * 平均情况：O(n²) - 但比传统冒泡排序稍好
     * 最坏情况：O(n²) - 数组完全逆序时
     * 空间复杂度：O(1)
     * 只使用了常数级别的额外空间
     */
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
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j + 1];
                        array[j + 1] = array[j];
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

        public class GroupBubbleSort {
            // 单一方法：分组冒泡排序（无辅助方法、无关联关系）
            public static void groupBubbleSort(int[] arr) {
                // 边界处理：空数组或长度<=1直接返回
                if (arr == null || arr.length <= 1) return;

                int n = arr.length;
                // 1. 步长从数组长度一半开始，逐步折半到1
                for (int gap = n / 2; gap > 0; gap /= 2) {
                    // 2. 遍历每个组的起始下标（0 ~ gap-1）
                    for (int start = 0; start < gap; start++) {
                        // 3. 当前组内执行冒泡排序（直接嵌入，无辅助方法）
                        for (int i = start; i < n - gap; i += gap) {
                            for (int j = start; j < n - gap - (i - start); j += gap) {
                                // 组内相邻元素（按gap间隔）逆序则交换
                                if (arr[j] > arr[j + gap]) {
                                    int temp = arr[j];
                                    arr[j] = arr[j + gap];
                                    arr[j + gap] = temp;
                                }
                            }
                        }
                    }
                }
            }


        }
    }
}
