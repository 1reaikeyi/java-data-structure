package d希尔排序;

import java.util.Arrays;
import java.util.Random;

public class fuben {
    public static void main(String[] args) {
        int[] array = {6,4,5,2,3,1};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        shellSort(array);
    }

    public static void shellSort(int[] array) {
        int len = array.length;

        for (int gap = len / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < len; i++) {
                int temp = array[i];
                int j = i;
                while (j- gap >= 0&&array[j-gap] > temp) {
                    array[j] = array[j-gap];
                    j=j-gap;
                }
                array[j] = temp;
            }
        }
        System.out.println("排序后：Arrays.toString(array) = " + Arrays.toString(array));


    }
}
