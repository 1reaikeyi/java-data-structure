package merge合并数组;

public class Merge {


//    public static native void arraycopy(
//            Object src,   // 源数组
//            int srcPos,   // 源数组中开始复制的起始索引
//            Object dest,  // 目标数组
//            int destPos,  // 目标数组中开始存放的起始索引
//            int length    // 要复制的元素数量
//    );
    public void merge(int[] num1, int x, int xend, int[] nums2, int y, int yend, int[] dest, int a) {
        // 第一个数组已全部处理完毕
        if (x > xend) {
            System.arraycopy(nums2, y, dest, a, yend - y + 1);
            return;
        }
        // 第二个数组已全部处理完毕
        if (y > yend) {
            System.arraycopy(num1, x, dest, a, xend - x + 1);
            return;
        }

        // 比较两个数组当前元素，取较小的放入目标数组
        if (num1[x] < nums2[y]) {
            dest[a] = num1[x];
            merge(num1, x + 1, xend, nums2, y, yend, dest, a + 1);
        } else {
            dest[a] = nums2[y];
            merge(num1, x, xend, nums2, y + 1, yend, dest, a + 1);
        }
    }
    public void merge(int[] num1, int x, int xend, int[] nums2, int y, int yend) {
        // 计算需要合并的元素总数
        int Length = (xend - x + 1) + (yend - y + 1);
        int[] temp = new int[Length];
        int a = 0;
        int i = x, j = y;

        // 比较并合并两个数组的元素
        while (i <= xend && j <= yend) {
            if (num1[i] < nums2[j]) {
                temp[a++] = num1[i++];
            } else {
                temp[a++] = nums2[j++];
            }
        }

        // 处理剩余元素
        if (i <= xend) {
            System.arraycopy(num1, i, temp, a, xend - i + 1);
        }
        if (j <= yend) {
            System.arraycopy(nums2, j, temp, a, yend - j + 1);
        }
        System.arraycopy(temp, 0, num1, x, Length);
    }
}