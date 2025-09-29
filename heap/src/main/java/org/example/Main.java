package org.example;

import java.util.Arrays;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
     MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println("Arrays.toString(maxHeap.array) = " + Arrays.toString(maxHeap.array));
//        {7, 6, 4, 2, 1, 3}
        System.out.println("-----");
    }
}