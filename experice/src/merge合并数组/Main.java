package merge合并数组;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Merge m = new Merge();

        // 测试迭代方式的merge方法
        // 注意：要合并的子数组必须是有序的
        int[] nums1 = {1, 3, 5, 7, 2, 4, 6, 8}; // 前4个元素[1,3,5,7]有序，后4个[2,4,6,8]有序
        m.merge(nums1, 0, 3, nums1, 4, 7); // 合并两个有序子数组
        System.out.println("迭代合并后:");
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));
        // 测试递归方式的merge方法
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 8};
        int[] result = new int[arr1.length + arr2.length];
        m.merge(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1, result, 0);
        System.out.println("递归合并结果:");
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(result));


    }
}
