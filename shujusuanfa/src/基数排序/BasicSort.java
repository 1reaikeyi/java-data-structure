package 基数排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BasicSort {


    public static int[] basicSort(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
        int count = 0;
        while (max != 0) {
            max /= 10;
            count++;
        }
        System.out.println("位数 = " + count);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
        }
        //1  new ArrayList<>()
        //2  new ArrayList<>()
        //3  new ArrayList<>()
        //4  new ArrayList<>()
        //5  new ArrayList<>()
        //6  new ArrayList<>()
        //7  new ArrayList<>()
        //8  new ArrayList<>()
        //9  new ArrayList<>()
        //10 new ArrayList<>()

        for (int i = 0; i < 10; i++) {
            System.out.println("第 " + (i+1) + " 个桶: " + list.get(i));

        }
        System.out.println("初始化：**************************");
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int ge_digit = num % 10;
            list.get(ge_digit).add(num);
        }
        for (int i = 0; i < 10; i++) {
            Collections.sort(list.get(i));
            System.out.println("第 " + i + " 个桶: " + list.get(i));

        } System.out.println("第一次：**************************");
        System.out.print("当前排序后的 array: [");
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> bucket = list.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(bucket.get(j)+"\t");
            }

        }
        System.out.println("]");




        //第2次排序
        for (ArrayList<Integer> bucket : list) {
            bucket.clear();
        }
        //清空
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int ten_digit = (num / 10) % 10; // 获取十位数
            list.get(ten_digit).add(num);
        }
        for (int i = 0; i < 10; i++) {
            Collections.sort(list.get(i));
            System.out.println("第 " + i + " 个桶: " + list.get(i));

        }
        System.out.println("第二次：***************************");
        System.out.print("当前排序后的 array: [");
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> bucket = list.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(bucket.get(j)+"\t");
            }

        }
        System.out.println("]");


//        第三次排序
        for (ArrayList<Integer> bucket : list) {
            bucket.clear();
        }
        //清空
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int hundred_digit = (num / 100) % 10; // 获取百位数
            list.get(hundred_digit).add(num);
        }
        for (int i = 0; i < 10; i++) {
            Collections.sort(list.get(i));
            System.out.println("第 " + i + " 个桶: " + list.get(i));

        } System.out.println("第三次：***************************");
        System.out.print("当前排序后的 array: [");
        for (int i = 0; i < list.size(); i++) {

            ArrayList<Integer> bucket = list.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(bucket.get(j)+"\t");
            }

        }
        System.out.println("]");

        return array;
    }
    public static void main(String[] args) {
        int[] array = {1, 22, 333, 456, 789, 90};
        int[] sorted = basicSort(array);
        System.out.println("排序后的数组: " + Arrays.toString(sorted));
        
       
    }
}
